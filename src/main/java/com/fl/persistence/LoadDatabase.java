package com.fl.persistence;


import com.fl.pojo.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@Slf4j
class LoadDatabase {

    Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClientRepository repository) {
        return args -> {
            logger.info("Preloading " + repository.save(new Client("hospital-1")));
            logger.info("Preloading " + repository.save(new Client("hospital-2")));
        };
    }
}


