package park.oauth2Jwt.dto;

import java.util.regex.Pattern;

public record AddUserRequest(String email, String password) {

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
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && Pattern.matches(emailRegex, email);
    }
}
