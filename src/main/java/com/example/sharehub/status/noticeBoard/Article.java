package com.example.sharehub.status.noticeBoard;

public enum Article {
    SUCCESS(401),
    FAIL(402);

    private final int status;
    Article(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
