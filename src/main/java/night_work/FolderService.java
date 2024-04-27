package night_work;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FolderService {
    private final folder_repository FolderRepository;

    @Autowired
    public FolderService(folder_repository folderRepository) {
        this.FolderRepository = folderRepository;
    }

    public List<Folder> getAllFolders() {
        return FolderRepository.findAll();
    }

    public Folder createFolder(Folder folder) {
        return FolderRepository.save(folder);
    }

    public Folder getFolderById(Long id) {
        return FolderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Folder not found with id: " + id));
    }

    public void deleteFolder(Long id) {
        FolderRepository.deleteById(id);
    }
}