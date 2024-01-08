package cu.edu.cujae.pweb.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;
import cu.edu.cujae.pweb.dto.UsuarioDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cu.edu.cujae.pweb.dto.UserDto;


public class UserPrincipal implements UserDetails {
    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String rol;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean active;

    public UserPrincipal(Long id, String username, String fullName, String password, String email, String rol, String token, Collection<? extends GrantedAuthority> authorities, boolean active) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.token = token;
        this.authorities = authorities;
        this.active = active;
    }

    public static UserPrincipal create(UserAuthenticatedDto user) {
    	List<GrantedAuthority> authorities;
    	try {
    		Collection<String> roleNames = user.getRolList();
    		authorities = AuthorityUtils.createAuthorityList(roleNames.toArray(new String[0]));
		} catch (Exception e) {
			authorities = Collections.
	                singletonList(new SimpleGrantedAuthority("ROLE_USER"));
			
		}
    	return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getPassword(),
                user.getEmail(),
                user.getRol(),
                user.getToken(),
                authorities,
                true
        );
    }

    public static UserPrincipal create(UserAuthenticatedDto user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return userPrincipal;
    }

    public Long getId() {
        return id;
    }

    public String getUserId(){
        return String.valueOf(this.id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        return active;
    }
}
