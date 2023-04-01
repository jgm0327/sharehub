package com.example.sharehub.member.entity;

import com.example.sharehub.noticeBoard.article.entity.Article;
import com.example.sharehub.noticeBoard.board.entity.Board;
import com.example.sharehub.noticeBoard.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "member")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String profile;

    private String role;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Board> boards;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Article> articles;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;
}
