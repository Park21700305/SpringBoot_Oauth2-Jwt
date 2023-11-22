package park.oauth2Jwt.dto;

import park.oauth2Jwt.domain.User;

import java.util.regex.Pattern;

public record AddUserRequest(
        String email,
        String password,
        String nickname
) {

    // 컴팩트 생성자를 사용하여 유효성 검사 수행
    public AddUserRequest {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("이메일 형식 지켜라.");
        }
        if (password == null || password.length() <= 4) {
            throw new IllegalArgumentException("비번이 4자리 이상은 돼야지 바보야.");
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^([\\w\\.\\_\\-])*[a-zA-Z0-9]+([\\w\\.\\_\\-])*([a-zA-Z0-9])+([\\w\\.\\_\\-])+@([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]{2,8}$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
