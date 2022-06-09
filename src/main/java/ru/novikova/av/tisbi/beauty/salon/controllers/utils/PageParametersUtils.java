package ru.novikova.av.tisbi.beauty.salon.controllers.utils;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.novikova.av.tisbi.beauty.salon.controllers.constants.PageBreadcrumbs;

@Slf4j
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
        params.put("userAuthenticated", Boolean.TRUE);

        userDetails.getAuthorities().forEach(
            a  -> {
              String authority = a.getAuthority();
              log.info("has authority {}", authority);

              switch (authority) {
                case "canAdminPanelUse" -> params.put("hasAdminAuthority", Boolean.TRUE);
                case "canMasterCabinetUse" -> params.put("hasMasterAuthority", Boolean.TRUE);
              }

            }
        );
      } else {
        params.put("userAuthenticated", Boolean.FALSE);
        params.put("userDetails", "");
      }
    } else {
      params.put("userAuthenticated", Boolean.FALSE);
      params.put("userDetails", "");
    }
  }

  public static void enableBreadcrumbs(PageBreadcrumbs breadcrumbs, Map<String, Object> params) {
    params.put("enabledBreadcrumbs", true);
    params.put("pages", breadcrumbs.getPages());
  }

}
