package night_work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/folders")
public class foldercontrol {
    private final FolderService folderService;

    @Autowired
    public foldercontrol(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping
    public List<Folder> getAllFolders() {
        return folderService.getAllFolders();
    }

    @PostMapping
    public Folder createFolder(@Valid @RequestBody Folder folder) {
        return folderService.createFolder(folder);
    }

    @GetMapping("/{id}")
    public Folder getFolderById(@PathVariable Long id) {
        return folderService.getFolderById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFolder(@PathVariable Long id) {
        folderService.deleteFolder(id);
        return ResponseEntity.ok().build();
    }
}
