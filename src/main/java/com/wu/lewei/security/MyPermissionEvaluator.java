package com.wu.lewei.security;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class MyPermissionEvaluator implements PermissionEvaluator {

    private static final Log LOG = LogFactory.getLog(MyPermissionEvaluator.class);

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication,
            Serializable hierarchyNode, String permission, Object activityObject) {
        return true;
    }

}
