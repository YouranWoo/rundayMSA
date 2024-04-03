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
    LogRepository logRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RunningStarted'"
    )
    public void wheneverRunningStarted_CreateLog(
        @Payload RunningStarted runningStarted
    ) {
        RunningStarted event = runningStarted;
        System.out.println(
            "\n\n##### listener CreateLog : " + runningStarted + "\n\n"
        );

        // Sample Logic //
        Log.createLog(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RunningEnded'"
    )
    public void wheneverRunningEnded_CompleteLog(
        @Payload RunningEnded runningEnded
    ) {
        RunningEnded event = runningEnded;
        System.out.println(
            "\n\n##### listener CompleteLog : " + runningEnded + "\n\n"
        );

        // Sample Logic //
        Log.completeLog(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RunningForcedStop'"
    )
    public void wheneverRunningForcedStop_RemoveLog(
        @Payload RunningForcedStop runningForcedStop
    ) {
        RunningForcedStop event = runningForcedStop;
        System.out.println(
            "\n\n##### listener RemoveLog : " + runningForcedStop + "\n\n"
        );

        // Sample Logic //
        Log.removeLog(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LikeUndone'"
    )
    public void wheneverLikeUndone_UpdateLikes(@Payload LikeUndone likeUndone) {
        LikeUndone event = likeUndone;
        System.out.println(
            "\n\n##### listener UpdateLikes : " + likeUndone + "\n\n"
        );

        // Sample Logic //
        Log.updateLikes(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LikeSent'"
    )
    public void wheneverLikeSent_UpdateLikes(@Payload LikeSent likeSent) {
        LikeSent event = likeSent;
        System.out.println(
            "\n\n##### listener UpdateLikes : " + likeSent + "\n\n"
        );

        // Sample Logic //
        Log.updateLikes(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
