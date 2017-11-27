package arkhipov.traffic.controllers;

import arkhipov.traffic.models.Record;
import arkhipov.traffic.models.User;
import arkhipov.traffic.repositories.RecordRepository;
import arkhipov.traffic.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/traffic")
public class TrafficController {
    private static Logger LOG = LoggerFactory.getLogger(TrafficController.class);

    private UserRepository userRepository;
    private RecordRepository recordRepository;

    @Autowired
    public TrafficController(UserRepository userRepository, RecordRepository recordRepository) {
        this.userRepository = userRepository;
        this.recordRepository = recordRepository;
    }

    @RequestMapping
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @RequestMapping("user")
    public List<Record> getTrafficByUserId(
            @RequestParam(value = "userId") int userId,
            @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") @RequestParam(value = "startDateTime") LocalDateTime startDateTime,
            @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") @RequestParam(value = "endDateTime") LocalDateTime endDateTime) {
        List<Record> records = recordRepository.findByUserIdAndDateTimeBetween(userId, startDateTime, endDateTime).orElse(null);
        LOG.info("Request with parameters {userId=" + userId +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                "} -> Response: " + (records != null));
        return records;
    }
}