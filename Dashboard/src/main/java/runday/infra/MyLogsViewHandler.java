// package runday.infra;

// import java.io.IOException;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cloud.stream.annotation.StreamListener;
// import org.springframework.messaging.handler.annotation.Payload;
// import org.springframework.stereotype.Service;
// import runday.config.kafka.KafkaProcessor;
// import runday.domain.*;

// @Service
// public class MyLogsViewHandler {

//     //<<< DDD / CQRS
//     @Autowired
//     private MyLogsRepository myLogsRepository;

//     @StreamListener(KafkaProcessor.INPUT)
//     public void whenLogCompleted_then_CREATE_1(
//         @Payload LogCompleted logCompleted
//     ) {
//         try {
//             if (!logCompleted.validate()) return;

//             // view 객체 생성
//             MyLogs myLogs = new MyLogs();
//             // view 객체에 이벤트의 Value 를 set 함
//             myLogs.setId(logCompleted.getId());
//             myLogs.setStartTime(logCompleted.getStartTime());
//             myLogs.setRunningTime(Date.valueOf(logCompleted.getRunningTime()));
//             myLogs.setUserDiary(logCompleted.getUserDiary());
//             myLogs.setLikesCount(logCompleted.getLikesCount());
//             myLogs.setPhoto(BigDecimal.valueOf(logCompleted.getRunningPhoto()));
//             // view 레파지 토리에 save
//             myLogsRepository.save(myLogs);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @StreamListener(KafkaProcessor.INPUT)
//     public void whenLikesUpdated_then_UPDATE_1(
//         @Payload LikesUpdated likesUpdated
//     ) {
//         try {
//             if (!likesUpdated.validate()) return;
//             // view 객체 조회
//             Optional<MyLogs> myLogsOptional = myLogsRepository.findById(
//                 likesUpdated.getId()
//             );

//             if (myLogsOptional.isPresent()) {
//                 MyLogs myLogs = myLogsOptional.get();
//                 // view 객체에 이벤트의 eventDirectValue 를 set 함
//                 myLogs.setLikesCount(likesUpdated.getLikesCount());
//                 // view 레파지 토리에 save
//                 myLogsRepository.save(myLogs);
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @StreamListener(KafkaProcessor.INPUT)
//     public void whenLogEditted_then_UPDATE_2(@Payload LogEditted logEditted) {
//         try {
//             if (!logEditted.validate()) return;
//             // view 객체 조회
//             Optional<MyLogs> myLogsOptional = myLogsRepository.findById(
//                 logEditted.getId()
//             );

//             if (myLogsOptional.isPresent()) {
//                 MyLogs myLogs = myLogsOptional.get();
//                 // view 객체에 이벤트의 eventDirectValue 를 set 함
//                 myLogs.setUserDiary(logEditted.getUserDiary());
//                 myLogs.setPhoto(
//                     BigDecimal.valueOf(logEditted.getRunningPhoto())
//                 );
//                 // view 레파지 토리에 save
//                 myLogsRepository.save(myLogs);
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @StreamListener(KafkaProcessor.INPUT)
//     public void whenLogDeleted_then_DELETE_1(@Payload LogDeleted logDeleted) {
//         try {
//             if (!logDeleted.validate()) return;
//             // view 레파지 토리에 삭제 쿼리
//             myLogsRepository.deleteById(logDeleted.getId());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
//     //>>> DDD / CQRS
// }
