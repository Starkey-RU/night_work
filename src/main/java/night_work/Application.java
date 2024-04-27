package night_work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        setupDemo();
    }

    private static void setupDemo() {
        FolderService folderService = new FolderService();
        NoteService noteService = new NoteService();

        Folder folder1 = createFolder("Folder 1", folderService);
        createNote("Note 1", "Artem Ivanovich", folder1, noteService);
        createNote("Note 2", "Prostite", folder1, noteService);

        Folder folder2 = createFolder("Folder 2", folderService);
        createNote("Note 3", "Za opozdanie, ya ne hotel, tak polycilos'", folder2, noteService);
    }

    private static Folder createFolder(String name, FolderService service) {
        Folder folder = new Folder();
        folder.setName(name);
        service.createFolder(folder);
        return folder;
    }

    private static void createNote(String title, String content, Folder folder, NoteService service) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setFolder(folder);
        service.createNote(note);
    }
}
