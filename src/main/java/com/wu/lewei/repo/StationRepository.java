package com.wu.lewei.repo;

import com.wu.lewei.dto.StationDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cn40580 on 2016-10-09.
 */
public interface StationRepository extends MongoRepository<StationDTO, String> {

}
