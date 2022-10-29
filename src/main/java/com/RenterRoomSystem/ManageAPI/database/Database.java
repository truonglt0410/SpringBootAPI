package com.RenterRoomSystem.ManageAPI.database;

import com.RenterRoomSystem.ManageAPI.models.Building;
import com.RenterRoomSystem.ManageAPI.repositories.BuildingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(BuildingRepository buildingRepository){
      return new CommandLineRunner() {
          @Override
          public void run(String... args) throws Exception {
              /*Building building1 = new Building("hoa lac","09876544321","test","welcome","test","test nua",0);
              Building building2 = new Building("hoa lac2","1234567891","test2","welcome2","test2","test nua2",0);
              logger.info("insert data"+buildingRepository.save(building1));
              logger.info("insert data"+buildingRepository.save(building2));*/
          }
      };
    };

}
