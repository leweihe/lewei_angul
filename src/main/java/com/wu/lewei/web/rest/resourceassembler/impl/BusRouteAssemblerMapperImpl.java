package com.wu.lewei.web.rest.resourceassembler.impl;

import com.wu.lewei.dto.BusRouteDTO;
import com.wu.lewei.web.rest.resource.BusRouteResource;
import com.wu.lewei.web.rest.resourceassembler.BusRouteResourceAssembler;
import com.wu.lewei.web.rest.resourceassembler.mapper.BusRouteResourceMapper;
import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 * Created by cn40580 on 2016-10-10.
 */
@Component
public class BusRouteAssemblerMapperImpl implements BusRouteResourceAssembler {
    @Inject
    private BusRouteResourceMapper busRouteResourceMapper;

    @Override
    public BusRouteResource toResource(@NotNull BusRouteDTO entity) {
        Validate.notNull(entity);
        BusRouteResource res = busRouteResourceMapper.DTOtoResource(entity);

        return res;
    }
}
