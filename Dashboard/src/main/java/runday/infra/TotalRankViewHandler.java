package runday.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import runday.config.kafka.KafkaProcessor;
import runday.domain.*;

@Service
public class TotalRankViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private TotalRankRepository totalRankRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUserRanked_then_UPDATE_1(@Payload UserRanked userRanked) {
        try {
            if (!userRanked.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
