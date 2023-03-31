package com.example.sharehub.noticeBoard.article.entity;

import com.example.sharehub.member.entity.Member;
import com.example.sharehub.noticeBoard.board.entity.Board;
import com.example.sharehub.noticeBoard.comment.entity.Comment;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name="article")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Timestamp
    private LocalDate createdAt;

    private String createdBy;

    private String picture;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Board board;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;
}
