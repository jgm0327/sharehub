package com.example.sharehub.authentication.controller;

import com.example.sharehub.authentication.dto.JoinDTO;
import com.example.sharehub.authentication.service.AuthenticationService;
import com.example.sharehub.status.authentication.Join;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(value = "/join", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> join(@RequestBody JoinDTO joinDTO) {
        int status = authenticationService.join(joinDTO);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/check/userId")
    public ResponseEntity<Map<String, Integer>> checkUserId(@RequestBody Map<String, String> userId) {
        int status = authenticationService.checkUserId(userId.get("userId"));
        Map<String, Integer> result = Map.of("statusCode", status);
        if (status == Join.REDUNDANT_ID.getStatus()) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/check/nickname")
    public ResponseEntity<Map<String, Integer>> checkNick(@RequestBody Map<String, String> nickName) {
        int status = authenticationService.checkNick(nickName.get("nickName"));
        Map<String, Integer> result = Map.of("statusCode", status);
        if (status == Join.REDUNDANT_NICKNAME.getStatus()) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(result);
    }
}
