package com.rt.config;

import static com.rt.constant.EComAppConstant.APP_CONFIG_ADMIN_ROLE;

import com.rt.service.EComAppAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Application Event listener to start processing after application started
 */
@Component
public class ApplicationEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationEventListener.class);

  private final String assignAdminRoleToEmailId;

  private final EComAppAdminService eComAppAdminService;

  public ApplicationEventListener(@Value(APP_CONFIG_ADMIN_ROLE) String assignAdminRoleToEmailId,
      EComAppAdminService eComAppAdminService) {
    this.assignAdminRoleToEmailId = assignAdminRoleToEmailId;
    this.eComAppAdminService = eComAppAdminService;
  }

  /**
   * Invoke on Application after start to map admin role if not present in system
   */
  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationAfterStartup() {
    LOGGER.info("Assigning ROLE_ADMIN to email id: {}", assignAdminRoleToEmailId);
    eComAppAdminService.checkAndAssignAdminRoleToUserIfNotPresentInSystem(assignAdminRoleToEmailId);
  }

}
