package com.wu.lewei.web.rest.resourceassembler.impl;

import com.wu.lewei.dao.UserDTO;
import com.wu.lewei.web.rest.resource.UserResource;
import com.wu.lewei.web.rest.resourceassembler.UserResourceAssembler;
import com.wu.lewei.web.rest.resourceassembler.mapper.UserResourceMapper;
import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 * Created by cn40580 on 2016-10-10.
 */
@Component
public class UserResourceAssemblerMapperImpl implements UserResourceAssembler {
    @Inject
    private UserResourceMapper userResourceMapper;

    @Override
    public UserResource toResource(@NotNull UserDTO entity) {
        Validate.notNull(entity);
        UserResource dto = userResourceMapper.DTOtoResource(entity);

        return dto;
    }
}
