package com.wu.lewei.dto;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by cn40580 on 2016-10-10.
 */
public class BusRouteDTO {

    @Id
    private String id;
    private String routeName;
    @OneToMany(mappedBy = "stationDTO")
    private List<StationDTO> stations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
