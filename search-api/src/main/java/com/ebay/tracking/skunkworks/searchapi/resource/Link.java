
package com.ebay.tracking.skunkworks.searchapi.resource;

import com.ebay.tracking.skunkworks.searchapi.entity.Entity;
import org.reflections.Reflections;

import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Link extends LinkedHashMap {
    private static final String SERIALIZER_PACKAGE_NAME = "com.ebay.tracking.skunkworks.searchapi.entity";
    public static final String PATH_SEPARATOR = "/";

    public static final Map<Class<? extends Entity>, String> entityUrlMapper = new HashMap<>();

    static {
        final Reflections reflections = new Reflections(SERIALIZER_PACKAGE_NAME);
        final Set<Class<? extends Entity>> entityClasses = reflections.getSubTypesOf(Entity.class);
        for (Class<? extends Entity> clazz : entityClasses) {
            String className = clazz.getSimpleName();
            className = className.replaceFirst("" + className.charAt(0), String.valueOf(Character.toLowerCase(className.charAt(0)))) ;
            entityUrlMapper.put(clazz, PATH_SEPARATOR + className);
        }
    }

    public Link(UriInfo info, Entity entity) {
        this(getFullyQualifiedContextPath(info), entity);
    }

    public Link(String fqBasePath, Entity entity) {
        String href = createHref(fqBasePath, entity);
        put("href", href);
    }

    public Link(UriInfo info, String subPath) {
        this(getFullyQualifiedContextPath(info), subPath);
    }

    public Link(String fqBasePath, String subPath) {
        String href = fqBasePath + subPath;
        put("href", href);
    }

    protected static String getFullyQualifiedContextPath(UriInfo info) {
        String fq = info.getBaseUri().toString();
        if (fq.endsWith("/")) {
            return fq.substring(0, fq.length()-1);
        }
        return fq;
    }

    protected String createHref(String fqBasePath, Entity entity) {
        return fqBasePath + entityUrlMapper.get(entity.getClass()) + PATH_SEPARATOR + entity.getId();
    }

    public String getHref() {
        return (String)get("href");
    }

}
