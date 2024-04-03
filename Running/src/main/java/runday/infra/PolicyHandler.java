package runday.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import runday.config.kafka.KafkaProcessor;
import runday.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RunningRepository runningRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RunningPaused'"
    )
    public void wheneverRunningPaused_ForceStopRunningIfMoreThan10Min(
        @Payload RunningPaused runningPaused
    ) {
        RunningPaused event = runningPaused;
        System.out.println(
            "\n\n##### listener ForceStopRunningIfMoreThan10Min : " +
            runningPaused +
            "\n\n"
        );

        // Comments //
        //Stop running if there is a delay of more than 5 minutes.

        // Sample Logic //
        Running.forceStopRunningIfMoreThan10Min(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
