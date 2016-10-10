package com.wu.lewei.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.wu.lewei.dao.UserDTO;
import com.wu.lewei.service.UserService;
import com.wu.lewei.web.rest.resource.UserResource;
import com.wu.lewei.web.rest.resourceassembler.UserResourceAssembler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cn40580 on 2016-10-10.
 */
@RestController
@RequestMapping("/app/rest")
public class UserWebService {

    private static final Log LOG = LogFactory.getLog(UserWebService.class);

    @Inject
    private UserService userService;

    @Inject
    private UserResourceAssembler userResourceAssembler;

    @RequestMapping(value = "/users/me",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
    @Timed
    public ResponseEntity<UserResource> getUserMe(Principal principal) {
        LOG.debug(String.format("REST request to get User: %s", principal.getName()));
        try {
            UserResource ur = userResourceAssembler.toResource(userService.findUserByUserName(principal.getName()));
            return new ResponseEntity<>(ur, HttpStatus.OK);
        } catch (UsernameNotFoundException unf) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (AccessDeniedException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/users/all",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
    @Timed
    public ResponseEntity<List<UserResource>> getUserMe() {
        List<UserDTO> us = userService.findAllUsers();
        List<UserResource> res = us.stream().map(n -> userResourceAssembler.toResource(n)).collect(Collectors.toList());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
