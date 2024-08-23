package BMproject.BMproject1.domain.posting.repository;

import BMproject.BMproject1.domain.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findAllByAuthor(String author);
}
