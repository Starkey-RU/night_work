package night_work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface repository extends JpaRepository<Note, Long> {
    List<Note> findAllByFolderId(Long folderId);
}
