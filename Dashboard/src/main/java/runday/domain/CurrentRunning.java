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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date runningStartTime;
    private Float runningStartLatitude;
    private Float runningStartLongitude;
    private Date runningEndTime;
    private Float runningEndLatitude;
    private Float runningEndLongitude;
    private Date runningTime;
}
