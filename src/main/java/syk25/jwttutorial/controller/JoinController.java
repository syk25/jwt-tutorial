package syk25.jwttutorial.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import syk25.jwttutorial.dto.JoinDto;
import syk25.jwttutorial.service.JoinService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<?> joinProcess(JoinDto joinDto) {
        joinService.joinProcess(joinDto);

        return ResponseEntity.ok().build();
    }
}
