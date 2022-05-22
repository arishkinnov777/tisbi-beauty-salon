package ru.novikova.av.tisbi.beauty.salon.security;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.novikova.av.tisbi.beauty.salon.security.entities.RolePrivilegeEntity;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserEntity;
import ru.novikova.av.tisbi.beauty.salon.security.entities.UserRoleEntity;
import ru.novikova.av.tisbi.beauty.salon.security.repository.UserAccountRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseUserDetailsService implements UserDetailsService {

  private final UserAccountRepository userAccountRepository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userAccount = userAccountRepository.findByUsername(username);
    if (userAccount == null) {
      throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
    }

    Set<GrantedAuthority> authorities = new HashSet<>();

    for (UserRoleEntity userToRole : userAccount.getUserRoles()) {
      authorities.add(new SimpleGrantedAuthority("ROLE_" + userToRole.getRole().getCode()));
      for (RolePrivilegeEntity userRoleToPrivilege : userToRole.getRole().getRolePrivileges()) {
        authorities.add(new SimpleGrantedAuthority(userRoleToPrivilege.getPrivilege().getCode()));
        log.info("User {} has privilege {}", userAccount.getUsername(), userRoleToPrivilege.getPrivilege().getCode());
      }
    }

    return new CustomUserDetails(userAccount.getUsername(), userAccount.getPassword(), userAccount.isActive(), authorities);
  }
}
