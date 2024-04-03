package runday.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import runday.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "likes", path = "likes")
public interface LikesRepository
    extends PagingAndSortingRepository<Likes, Long> {}
