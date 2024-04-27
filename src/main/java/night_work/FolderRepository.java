package night_work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import
//more in future.

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    // а зачем?
}
