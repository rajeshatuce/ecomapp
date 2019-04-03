package com.rt.config;

import static com.rt.constant.EComAppConstant.EMAIL;
import static com.rt.constant.EComAppConstant.ROLE_USER;
import static java.lang.String.join;

import com.rt.model.UserRoleMapping;
import com.rt.service.EComAppAdminService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

/**
 * EComApp Authorities extractor to identify logged in user(emailId) has which all role setup in
 * System
 */
@Component
public class EComAppAuthoritiesExtractor implements AuthoritiesExtractor {

  private final EComAppAdminService eComAppAdminService;

  @Autowired
  public EComAppAuthoritiesExtractor(EComAppAdminService eComAppAdminService) {
    this.eComAppAdminService = eComAppAdminService;
  }

  @Override
  public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
    return AuthorityUtils
        .commaSeparatedStringToAuthorityList(asAuthorities(map));
  }

  /**
   * Utility API to find roles for email id and return as comma separated string
   *
   * @param map containing email information for loggged in user
   * @return comma separated roles
   */
  private String asAuthorities(Map<String, Object> map) {
    List<String> authorities = new ArrayList<>();
    authorities.add(ROLE_USER);//Default role every user need to have
    //Populate other role if any from DB
    List<UserRoleMapping> userRoleMappings = eComAppAdminService
        .findRolesForUser(map.get(EMAIL).toString());
    for (UserRoleMapping userRoleMapping : userRoleMappings) {
      authorities.add(userRoleMapping.getUserRole().toString());
    }
    return join(",", authorities);
  }
}
