package com.example.sharehub.status.noticeBoard;

public enum Comment {
    SUCCESS(501),
    FAIL(502);

    private final int status;
    Comment(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
