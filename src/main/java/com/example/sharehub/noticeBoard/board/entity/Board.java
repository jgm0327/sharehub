package com.example.sharehub.noticeBoard.board.entity;

import com.example.sharehub.member.entity.Member;
import com.example.sharehub.noticeBoard.article.entity.Article;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name="board")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Timestamp
    private LocalDate createdAt;

    private String createdBy;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Article> articles;
}
