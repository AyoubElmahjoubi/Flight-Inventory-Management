package com.Demo.Flight_Inventory_Management.email;


import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("activate_account"),
    TICKET_EMAIL("ticket_email");

    private final String name;

    EmailTemplateName(String name) {
        this.name = name;
    }
}
