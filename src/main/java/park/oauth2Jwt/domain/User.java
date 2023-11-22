package park.oauth2Jwt.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Builder
    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public User update(String nickname) {
        this.nickname = nickname;

        return this;
    }


    /*
    getAuthorities(): 사용자가 시스템에서 어떤 일을 할 수 있는지 결정하는 '키'와 같은 역할
     ex) 사용자가 어떤 페이지를 볼 수 있거나, 어떤 작업을 수행할 수 있는지를 결정하는 데 사용
        ex) 온라인 쇼핑몰 시스템: 사용자가 로그인하면, 시스템은 getAuthorities()를 호출 => 이 사용자에게 어떤 권한이 있는지 확인
    코드에서 return List.of(new SimpleGrantedAuthority("user"));는 이 사용자가 '일반 사용자(user)' 권한을 가지고 있음을 나타냄
    '일반 사용자' 권한을 가진 사람은 쇼핑몰에서 쇼핑을 할 수 있지만, 상품을 추가하거나 가격을 변경하는 등의 관리자 기능은 사용할 수 없음
    즉, getAuthorities() 메서드는 사용자가 시스템 내에서 할 수 있는 일의 '범위'를 정의
    이를 통해 어떤 사용자가 특정 기능을 사용할 수 있는지, 또는 특정 페이지에 접근할 수 있는지를 시스템이 결정할 수 있게 해줌
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}