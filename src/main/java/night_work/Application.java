package night_work;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner setupDemo(FolderService folderSvc, NoteService noteSvc) {
        return (args) -> {
            Folder folderOne = new Folder("Folder 1");
            folderSvc.createFolder(folderOne);

            Note note1 = new Note();
            note1.setTitle("Note 1");
            note1.setContent("Artem Ivanovich");
            note1.setFolder(folderOne);
            noteSvc.createNote(note1);

            Note note2 = new Note();
            note2.setTitle("Note 2");
            note2.setContent("Prostite za opozdanie");
            note2.setFolder(folderOne);
            noteSvc.createNote(note2);

            Folder folderTwo = new Folder("Folder 2");
            folderSvc.createFolder(folderTwo);


            Note note3 = new Note();
            note3.setTitle("Note 3");
            note3.setContent("Ne stav'te neattestaciy :(");
            note3.setFolder(folderTwo);
            noteSvc.createNote(note3);
        };
    }
}
