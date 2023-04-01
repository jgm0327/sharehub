package com.example.sharehub.status.noticeBoard;

public enum Board {
    SUCCESS(301),
    REDUNDANT_NAME(302);

    private final int status;
    Board(int status){
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
