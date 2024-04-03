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
public class CurrentRunningViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private CurrentRunningRepository currentRunningRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLogCreated_then_CREATE_1(@Payload LogCreated logCreated) {
        try {
            if (!logCreated.validate()) return;

            // view 객체 생성
            CurrentRunning currentRunning = new CurrentRunning();
            // view 객체에 이벤트의 Value 를 set 함
            currentRunning.setRunningStartTime(logCreated.getStartTime());
            currentRunning.setRunningStartLatitude(
                logCreated.getStartLatitude()
            );
            currentRunning.setRunningStartLongitude(
                logCreated.getStartLongitude()
            );
            // view 레파지 토리에 save
            currentRunningRepository.save(currentRunning);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRunningEnded_then_UPDATE_1(
        @Payload RunningEnded runningEnded
    ) {
        try {
            if (!runningEnded.validate()) return;
            // view 객체 조회
            Optional<CurrentRunning> currentRunningOptional = currentRunningRepository.findById(
                runningEnded.getId()
            );

            if (currentRunningOptional.isPresent()) {
                CurrentRunning currentRunning = currentRunningOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                currentRunning.setRunningEndTime(runningEnded.getEndTime());
                currentRunning.setRunningEndLatitude(
                    runningEnded.getEndLatitude()
                );
                currentRunning.setRunningEndLongitude(
                    runningEnded.getEndLongitude()
                );
                currentRunning.setRunningTime(runningEnded.getRunningTime());
                // view 레파지 토리에 save
                currentRunningRepository.save(currentRunning);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRunningForcedStop_then_DELETE_1(
        @Payload RunningForcedStop runningForcedStop
    ) {
        try {
            if (!runningForcedStop.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            currentRunningRepository.deleteById(runningForcedStop.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
