import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * *Представьте, что вы работаете над разработкой простого приложения для записной книжки,
 * которое позволяет пользователям добавлять, редактировать и удалять контакты.
 *
 * Ваша задача - придумать как можно больше различных тестов
 * (юнит-тесты, интеграционные тесты, сквозные тесты) для этого приложения.
 * Напишите название каждого теста, его тип и краткое описание того, что этот тест проверяет.
 */
public class Test {
    NoteBookRepository repo;
    @BeforeEach
    void testInit() {
        repo = new NoteBookRepository();
    }

    /**
     * Тест проверяет добавление записи
     */
    @org.junit.jupiter.api.Test
    void testAddNote(){
        for (int i = 1; i < 6; i++) {
            repo.addNote(new Note("i"));
        }
        assertEquals(5, repo.size());
    }

    /**
     * Тест проверяет удаление записи
     */
    @org.junit.jupiter.api.Test
    void testDeleteNote() {
        for (int i = 1; i < 6; i++) {
            repo.addNote(new Note("i"));
        }
        repo.deleteNote(2);
        repo.deleteNote(4);
        assertEquals(3, repo.size());
    }
    /**
     * Тест проверяет редактирование конкретной записи
     */
    @org.junit.jupiter.api.Test
    void testEditNote(){
        repo.addNote(new Note("First record"));
        repo.addNote(new Note("Second record"));
        repo.addNote(new Note("Third record"));
        repo.editNote(2, new Note("Change record"));
        assertEquals("Note: First record", repo.getValue(1));
        assertEquals("Note: Change record", repo.getValue(2));
        assertEquals("Note: Third record", repo.getValue(3));
    }

    /**
     * Интеграционный тест repo и noteService
     */
    @org.junit.jupiter.api.Test
    void testIntegrationNoteServiceEdit() {
        repo.addNote(new Note("for test"));
        NoteService noteService = new NoteService(repo);
        System.out.println(noteService.value(1));
        System.out.println(repo.getValue(1));
        assertEquals(repo.getValue(1), noteService.value(1));
    }
}
