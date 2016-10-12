package com.wu.lewei.web.rest.resourceassembler;

import com.wu.lewei.dto.BusRouteDTO;
import com.wu.lewei.web.rest.resource.BusRouteResource;
import org.springframework.hateoas.ResourceAssembler;

import javax.validation.constraints.NotNull;

/**
 * Created by cn40580 on 2016-10-10.
 */
public interface BusRouteResourceAssembler extends ResourceAssembler<BusRouteDTO, BusRouteResource> {

    public BusRouteResource toResource(@NotNull BusRouteDTO entity);
}
