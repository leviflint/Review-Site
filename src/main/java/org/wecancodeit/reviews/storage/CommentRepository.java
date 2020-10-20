package org.wecancodeit.reviews.storage;

import org.attoparser.dom.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Long> {
}
