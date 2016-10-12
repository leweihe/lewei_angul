package com.wu.lewei.repo;

import com.wu.lewei.dto.BusRouteDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cn40580 on 2016-10-09.
 */
public interface BusRouteRepository extends MongoRepository<BusRouteDTO, String> {

}
