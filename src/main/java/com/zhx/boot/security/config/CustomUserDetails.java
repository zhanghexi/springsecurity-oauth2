package com.zhx.boot.security.config;

import com.zhx.boot.security.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhx
 * @date 2018/11/1 17:22
 * @description
 */
@Data
public class CustomUserDetails implements UserDetails/*org.springframework.security.core.userdetails.User*/ {

    private User user;
    private List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    public CustomUserDetails(User user, List<String> authorities) {
        /*super(user.getUsername(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);*/
        this.user = user;
        for (String authority : authorities) {
            this.grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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

//    private final boolean enabled;
//    private final boolean accountNonExpired;
//    private final boolean credentialsNonExpired;
//    private final boolean accountNonLocked;
//    private final Set<GrantedAuthority> authorities;
//
//    public CustomUserDetails(User user, boolean enabled,
//                             boolean accountNonExpired, boolean credentialsNonExpired,
//                             boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        if (user != null
//                && !StringUtils.isBlank(user.getUsername())
//                && !StringUtils.isBlank(user.getPassword())) {
//            setUsername(user.getUsername());
//            setPassword(user.getPassword());
//            this.enabled = enabled;
//            this.accountNonExpired = accountNonExpired;
//            this.credentialsNonExpired = credentialsNonExpired;
//            this.accountNonLocked = accountNonLocked;
//            this.authorities = Collections.unmodifiableSet(new HashSet<>(CollectionUtils.emptyIfNull(authorities)));
//        } else {
//            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
//        }
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
}