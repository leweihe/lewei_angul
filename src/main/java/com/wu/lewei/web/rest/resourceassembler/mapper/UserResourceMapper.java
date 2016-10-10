package com.wu.lewei.web.rest.resourceassembler.mapper;

import com.wu.lewei.dao.UserDTO;
import com.wu.lewei.web.rest.resource.UserResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created by cn40580 on 2016-10-10.
 */
@Mapper
public interface UserResourceMapper {

    @Mappings({
            @Mapping(target = "links", ignore = true)
    })
    UserResource DTOtoResource(UserDTO entity);
}
