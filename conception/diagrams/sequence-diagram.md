``` mermaid
    sequenceDiagram
    participant User
    participant Frontend
    participant Auth0
    participant Third-Party Provider
    participant Backend
    participant database
title Sequence Diagram of authentification :
    autonumber
    alt Based login 
        User->>+Frontend: login Username&password
        Frontend->>+Backend: send credentials 
        Backend->>Backend: Validates credentials
        Backend-->>-Frontend: Returns JWT
        Frontend-->>-User: Stores JWT (e.g., in local storage)
    else social login
        rect rgb(128,128,128)
            User->>+Frontend: Login
            Frontend->>+Auth0: Sends login request
            Auth0->>+Third-Party Provider: Redirects to provider (e.g., Google)
            Third-Party Provider->>-Auth0: Sends authentication result
            Auth0->>-Frontend: Returns JWT
            Frontend->>-User: Stores JWT (e.g., in local storage)
        end 
    end
    User->>+Frontend: Makes API request (with JWT)
    Frontend->>+Backend: Sends request with JWT in headers
    Backend-->>Auth0: Verifies JWT
    Auth0->>+Backend: Returns verification result
    Backend->>+database: interact with database
    database-->>-Frontend: Sends protected data
    Frontend-->>-User: Displays protected content

```

