package night_work;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FolderService {
    private final FolderRepository folderRepository; // Change the variable name to camelCase

    @Autowired
    public FolderService(FolderRepository folderRepository) { // Add FolderRepository as a parameter
        this.folderRepository = folderRepository; // Assign the parameter to the class field
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
