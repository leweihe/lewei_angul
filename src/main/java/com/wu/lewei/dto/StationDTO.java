package com.wu.lewei.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by cn40580 on 2016-10-10.
 */
public class StationDTO {

    @Id
    @GeneratedValue
    private String id;
    private Float x;
    private Float y;
    private String stationName;

    @ManyToOne
    private BusRouteDTO busRoute;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public BusRouteDTO getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(BusRouteDTO busRoute) {
        this.busRoute = busRoute;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
