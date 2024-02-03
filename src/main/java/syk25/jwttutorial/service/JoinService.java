package syk25.jwttutorial.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import syk25.jwttutorial.dto.JoinDto;
import syk25.jwttutorial.entity.UserEntity;
import syk25.jwttutorial.repository.UserRepository;

@Service
@AllArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 이후에 boolean으로 바꾸기
    public void joinProcess(JoinDto joinDto) {
        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        Boolean exists = userRepository.existsByUsername(username);
        if(exists){
            throw new RuntimeException("존재하는 회원 이름입니다.");
        }
        //TODO 권한부여 로직 수정 필요
        UserEntity data = UserEntity.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .role("ROLE_ADMIN") // 스프리에서 권한부여
                .build();

        userRepository.save(data);
    }
}
