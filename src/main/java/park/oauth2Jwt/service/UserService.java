package park.oauth2Jwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import park.oauth2Jwt.domain.User;
import park.oauth2Jwt.dto.AddUserRequest;
import park.oauth2Jwt.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //    @Transactional
    public User save(AddUserRequest dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return userRepository.save(dto.toEntity());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}