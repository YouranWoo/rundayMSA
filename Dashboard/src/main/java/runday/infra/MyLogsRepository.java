package runday.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import runday.domain.*;

@RepositoryRestResource(collectionResourceRel = "myLogs", path = "myLogs")
public interface MyLogsRepository
    extends PagingAndSortingRepository<MyLogs, Long> {}
