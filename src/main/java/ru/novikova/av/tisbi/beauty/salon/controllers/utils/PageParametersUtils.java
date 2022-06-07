package ru.novikova.av.tisbi.beauty.salon.controllers.utils;

import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.PageBreadcrumbs;

public final class PageParametersUtils {

  private PageParametersUtils() {}

  public static void fillUserDetails(Map<String, Object> params) {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    if (authentication != null) {
      Object principal = authentication.getPrincipal();
      UserDetails userDetails = principal instanceof UserDetails ? (UserDetails) principal : null;
      if (userDetails != null) {
        params.put("userDetails", userDetails.getUsername());
        params.put("username", userDetails.getUsername());
        params.put("userAuthenticated", true);

        userDetails.getAuthorities().stream()
            .filter(grantedAuthority -> grantedAuthority.getAuthority().equals("canAdminPanelUse"))
            .findAny()
            .ifPresent(grantedAuthority ->
                params.put("hasAdminAuthority", true)
            );

        userDetails.getAuthorities().stream()
            .filter(grantedAuthority -> grantedAuthority.getAuthority().equals("canMasterCabinetUse"))
            .findAny()
            .ifPresent(grantedAuthority ->
                params.put("hasMasterAuthority", true)
            );
      } else {
        params.put("userAuthenticated", false);
        params.put("userDetails", "");
      }
    } else {
      params.put("userAuthenticated", false);
      params.put("userDetails", "");
    }
  }

  public static void enableBreadcrumbs(PageBreadcrumbs breadcrumbs, Map<String, Object> params) {
    params.put("enabledBreadcrumbs", true);
    params.put("pages", breadcrumbs.getPages());
  }

}
