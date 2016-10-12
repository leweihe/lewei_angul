package com.wu.lewei.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.wu.lewei.dto.BusRouteDTO;
import com.wu.lewei.service.BusRouteService;
import com.wu.lewei.web.rest.resource.BusRouteResource;
import com.wu.lewei.web.rest.resourceassembler.BusRouteResourceAssembler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cn40580 at 2016-10-12 10:21 AM.
 */
@RestController
@RequestMapping("/app/rest")
public class BusRouteWebService {

    private static final Log LOG = LogFactory.getLog(BusRouteWebService.class);

    @Inject
    private BusRouteService busRouteService;

    @Inject
    private BusRouteResourceAssembler busRouteResourceAssembler;

    @RequestMapping(value = "/busroute/all",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
    @Timed
    public ResponseEntity<List<BusRouteResource>> getAllBusRoute() {
        List<BusRouteDTO> us = busRouteService.findAll();
        List<BusRouteResource> res = us.stream().map(n -> busRouteResourceAssembler.toResource(n)).collect(Collectors.toList());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
