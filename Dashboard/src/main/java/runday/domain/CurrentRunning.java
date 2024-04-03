package runday.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "CurrentRunning_table")
@Data
public class CurrentRunning {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date runningStartTime;
    private Long runningStartLatitude;
    private Long runningStartLongitude;
    private Date runningEndTime;
    private Long runningEndLatitude;
    private Long runningEndLongitude;
    private Date runningTime;
}
