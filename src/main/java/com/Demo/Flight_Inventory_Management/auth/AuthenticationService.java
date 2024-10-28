package com.Demo.Flight_Inventory_Management.auth;

import com.Demo.Flight_Inventory_Management.email.EmailService;
import com.Demo.Flight_Inventory_Management.email.EmailTemplateName;
import com.Demo.Flight_Inventory_Management.role.RoleRepository;
import com.Demo.Flight_Inventory_Management.user.Token;
import com.Demo.Flight_Inventory_Management.user.TokenRepository;
import com.Demo.Flight_Inventory_Management.user.User;
import com.Demo.Flight_Inventory_Management.user.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository ;
    private final PasswordEncoder passwordEncoder ;
    private final UserRepository userRepository ;
    private final TokenRepository tokenRepository ;
    private final EmailService emailService ;
    @Value("${spring.application.mailing.frontend.activation-url}")
    private String activationUrl;

    public void register(RegistrationRequest request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                // todo - better exception handling
                .orElseThrow(()-> new IllegalStateException("User Role not found or not initialized"));
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);
        sendValidationEmail(user);

    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = genrateAndSaveValidationToken(user);
        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );



    }

    private String genrateAndSaveValidationToken(User user) {
        String generatedToken = generateActivationCode(11);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int lenght) {
        String characters = "0123456789AaBcDdEeFfGgHh";
        StringBuilder activationCodeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < lenght; i++) {
            activationCodeBuilder.append(characters.charAt(secureRandom.nextInt(characters.length())));
        }
        return activationCodeBuilder.toString();
    }
}
