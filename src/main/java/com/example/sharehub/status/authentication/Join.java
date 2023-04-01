package com.example.sharehub.status.authentication;

public enum Join {
    SUCCESS(201),
    REDUNDANT_ID(202),
    REDUNDANT_NICKNAME(203);

    private final int status;
    private Join(int status){
        this.status = status;
    }

    public int getStatus(){
        return this.status;
    }
}
