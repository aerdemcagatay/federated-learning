package com.fl.requests;

import lombok.Data;

@Data
public class EnrollRequest {

    private String name;

    public EnrollRequest() {
    }

    public EnrollRequest(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Invalid name");

        this.name = name;
    }



}
