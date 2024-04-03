package runday.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import runday.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "rankings", path = "rankings")
public interface RankingRepository
    extends PagingAndSortingRepository<Ranking, Long> {}
