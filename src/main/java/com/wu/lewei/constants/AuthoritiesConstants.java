package com.wu.lewei.constants;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Constants to by used in security context all over the tool.
 *
 * @author cn40580
 */
public final class AuthoritiesConstants {

    private static final Logger LOG = LoggerFactory.getLogger(AuthoritiesConstants.class);

    private AuthoritiesConstants() {
    };

    public static final List<String> ALL_PERMISSIONS;

    static {
        ALL_PERMISSIONS = getAllPermissions();
    }

    public static final String LOGIN = "LOGIN";

    public static final String VIEW_ADMINISTRATION = "VIEW_ADMINISTRATION";
    public static final String ADMINISTRATE_USERS = "ADMINISTRATE_USERS";
    public static final String ADMINISTRATE_ROLES = "ADMINISTRATE_ROLES";
    public static final String ADMINISTRATE_TEAMS = "ADMINISTRATE_TEAMS";
    public static final String ADMINISTRATE_FACTORIES = "ADMINISTRATE_FACTORIES";
    public static final String UPDATE_OWN_ROLES_AT_RUNTIME = "UPDATE_OWN_ROLES_AT_RUNTIME";

    public static final String ADMINISTRATE_TRUCK_TYPES = "ADMINISTRATE_TRUCK_TYPES";
    public static final String ADMINISTRATE_TRUCK_SERIES = "ADMINISTRATE_TRUCK_SERIES";
    public static final String ADMINISTRATE_TRUCK_MODELS = "ADMINISTRATE_TRUCK_MODELS";
    public static final String ADMINISTRATE_REGIONS = "ADMINISTRATE_REGIONS";
    public static final String ADMINISTRATE_COUNTRIES = "ADMINISTRATE_COUNTRIES";
    public static final String ADMINISTRATE_CHARACTERISTIC = "ADMINISTRATE_CHARACTERISTIC";
    public static final String ADMINISTRATE_APPLICATION = "ADMINISTRATE_APPLICATION";
    public static final String ADMINISTRATE_CUST_REQ = "ADMINISTRATE_CUST_REQ";

    public static final String IMPORT_LOSPDATA = "IMPORT_LOSPDATA";
    public static final String IMPORT_SAPDATA = "IMPORT_SAPDATA";
    public static final String EXPORT_SAPDATA = "EXPORT_SAPDATA";
    public static final String IMPORT_PROCESS = "IMPORT_PROCESS";
    public static final String IMPORT_UPADATA = "IMPORT_UPADATA";

    public static final String ADMINISTRATE_HOME_PAGE = "ADMINISTRATE_HOME_PAGE";
    public static final String ADMINISTRATE_CURRENCY = "ADMINISTRATE_CURRENCY";

    public static final String ADMINISTRATE_TEASER_COTEAM = "ADMINISTRATE_TEASER_COTEAM";
    public static final String ADMINISTRATE_TEASER_SPECIALIST = "ADMINISTRATE_TEASER_SPECIALIST";
    public static final String SHARE_FAVORITES = "SHARE_FAVORITES";

    public static final String ADMINISTRATE_SCTE_ADMIN = "ADMINISTRATE_SCTE_ADMIN";
    public static final String ADMINISTRATE_SCTE_COTEAM = "ADMINISTRATE_SCTE_COTEAM";
    public static final String ADMINISTRATE_SCTE_SPECIALIST = "ADMINISTRATE_SCTE_SPECIALIST";
    public static final String ADMINISTRATE_SCTE_FACTORY = "ADMINISTRATE_SCTE_FACTORY";
    public static final String ADMINISTRATE_SCTE_BASIC = "ADMINISTRATE_SCTE_BASIC";

    public static final String ADMINISTRATE_PRICE_MOVES = "ADMINISTRATE_PRICE_MOVES";

    public static final String ADMINISTRATE_DQ_CATEGORY = "ADMINISTRATE_DQ_CATEGORY";
    public static final String ADMINISTRATE_DQ_QUEST = "ADMINISTRATE_DQ_QUEST";
    public static final String ADMINISTRATE_DQ_AREA = "ADMINISTRATE_DQ_AREA";

    public static final String ADMINISTRATE_STATISTICS = "ADMINISTRATE_STATISTICS";

    /**
     * Gets the all permissions.
     *
     * @return the all permissions
     */
    private static List<String> getAllPermissions() {
        Field[] fields = AuthoritiesConstants.class.getDeclaredFields();
        List<String> permissions = new ArrayList<>(fields.length);

        for (Field f : fields) {
            if (Modifier.isStatic(f.getModifiers()) && f.getType().equals(String.class)) {
                try {
                    permissions.add((String) f.get(null));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    LOG.error("Error getting all permissions", e);
                }
            }
        }
        return permissions;
    }
}
