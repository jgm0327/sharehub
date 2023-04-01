package com.example.sharehub.status.authentication;

public enum Login {
    SUCCESS(101),
    FAIL(102);

    private final int status;
    Login(int status){
        this.status = status;
    }

    public int getStatus(){
        return this.status;
    }
}
