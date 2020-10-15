package org.wecancodeit.reviews.storage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.HashTag;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {
}
