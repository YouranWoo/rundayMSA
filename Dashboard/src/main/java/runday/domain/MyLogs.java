package runday.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "MyLogs_table")
@Data
public class MyLogs {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date startTime;
    private Date runningTime;
    private String userDiary;
    private Integer likesCount;
    private BigDecimal photo;
}
