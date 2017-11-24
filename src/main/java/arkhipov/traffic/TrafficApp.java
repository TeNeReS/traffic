package arkhipov.traffic;

import arkhipov.traffic.models.Record;
import arkhipov.traffic.models.User;
import arkhipov.traffic.repositories.RecordRepository;
import arkhipov.traffic.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TrafficApp {
    private static final Logger log = LoggerFactory.getLogger(TrafficApp.class);

    public static void main(String[] args) {
        SpringApplication.run(TrafficApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, RecordRepository recordRepository) {
        return (args) -> {

            List<Record> list = recordRepository.findByUserIdAndDateTimeBetween(100001, LocalDateTime.of(2017, 5, 1, 0, 30, 10), LocalDateTime.of(2017, 5, 1, 0, 30, 11)).orElse(null);

            for (Record record : list) {
                log.info(record.toString());
            }

//            for (User user : userRepository.findAll()) {
//                log.info(user.toString());
//            }
        };
    }
}
