package night_work;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FolderService {
    private final FolderRepository folderRepository;

    @Autowired
    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Folder createFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    public Folder getFolderById(Long id) {
        return folderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Folder not found with id: " + id));
    }

    public void deleteFolder(Long id) {
        folderRepository.deleteById(id);
    }
}
