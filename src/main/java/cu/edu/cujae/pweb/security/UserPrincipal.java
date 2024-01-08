package cu.edu.cujae.pwebbackend.core.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cu.edu.cujae.pwebbackend.core.dto.UsuarioDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cu.edu.cujae.pwebbackend.core.dto.UserDto;


public class UserPrincipal implements UserDetails {
    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String rol;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean active;

    public UserPrincipal(Long id, String email, String password, boolean active,Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UsuarioDto user) {
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
                user.getEmail(),
                user.getPassword(),
                true,
                authorities
        );
    }

    public static UserPrincipal create(UsuarioDto user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return userPrincipal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdString(){
        return String.valueOf(getId());
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
