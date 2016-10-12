package com.wu.lewei.web.rest.resource;

import com.wu.lewei.dto.StationDTO;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by cn40580 on 2016-10-10.
 */
public class BusRouteResource extends ResourceSupport {
    private String routeName;
    private List<StationDTO> stations;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public List<StationDTO> getStations() {
        return stations;
    }

    public void setStations(List<StationDTO> stations) {
        this.stations = stations;
    }
}
