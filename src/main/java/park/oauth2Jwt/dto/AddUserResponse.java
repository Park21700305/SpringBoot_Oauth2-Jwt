package park.oauth2Jwt.dto;

public record AddUserResponse(
        Long id,
        String email,
        String nickname,
        String password
        ) {


}
