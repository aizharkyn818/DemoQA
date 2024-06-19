package com.demoqa.enums;

import lombok.Getter;

public enum Endpoints {

    ALERT("/alerts"),
    FRAMES("/frames"),
    CHECKBOX("/checkbox"),
    MENU("/menu"),
    BUTTONS("/buttons");


    @Getter
    String endpoint;

    Endpoints(String endpoint){
        this.endpoint = endpoint;
    }
}
