package com.example.sharehub.member.mapper;

import com.example.sharehub.authentication.dto.AuthenticationDTO;
import com.example.sharehub.authentication.dto.JoinDTO;
import com.example.sharehub.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "nickname", target = "nickname")
    @Mapping(source = "role", target = "role")
    @Mapping(target = "profile", ignore = true)
    @Mapping(target = "boards", ignore = true)
    @Mapping(target = "articles", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Member JoinDTOtoEntity(JoinDTO dto);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "role", target = "role")
    @Mapping(target = "authorities", ignore = true)
    AuthenticationDTO EntityToJoinDTO(Member member);
}
