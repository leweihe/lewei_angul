package com.wu.lewei.dto;

import com.wu.lewei.Application;
import com.wu.lewei.repo.BusRouteRepository;
import com.wu.lewei.repo.StationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Arrays;

/**
 * Created by cn40580 on 2016-10-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BusRouteDTOTest {

    @Inject
    BusRouteRepository busRouteRepo;

    @Inject
    StationRepository stationRepo;

    @Before
    public void before() {
        busRouteRepo.deleteAll();
        stationRepo.deleteAll();
    }

    @Test
    public void test() {
        BusRouteDTO busRoute = new BusRouteDTO();
        busRoute.setRouteName("B18");

        StationDTO s1 = new StationDTO();
        s1.setX(new Float(118.145754));
        s1.setY(new Float(24.489877));
        s1.setStationName("金尚路吕岭路交汇");

        StationDTO s2 = new StationDTO();
        s2.setX(new Float(118.139703));
        s2.setY(new Float(24.492064));
        s2.setStationName("泰禾花园");

        StationDTO s3 = new StationDTO();
        s3.setX(new Float(118.128888));
        s3.setY(new Float(24.48976));
        s3.setStationName("吕厝");

        StationDTO s4 = new StationDTO();
        s4.setX(new Float(118.119103));
        s4.setY(new Float(24.487417));
        s4.setStationName("湖滨北路");

        stationRepo.save(Arrays.asList(s1, s2, s3, s4));

        busRoute.setStations(Arrays.asList(s1, s2, s3, s4));

        busRouteRepo.save(busRoute);
    }
}