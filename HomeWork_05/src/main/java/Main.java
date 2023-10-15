public class Main {
    public static void main(String[] args) {
        NoteBookRepository repo = new NoteBookRepository();
        repo.addNote(new Note("first record"));
        repo.addNote(new Note("second record"));
        repo.addNote(new Note("third record"));
        System.out.println("Все записи:");
        System.out.println(repo);
        System.out.println("Редактирование второй записи");
        repo.editNote(2, new Note("Four record"));
        System.out.println(repo);
        System.out.println("Удаление первой записи");
        repo.deleteNote(1);
        System.out.println(repo);
        System.out.println(repo.getValue(2));
        System.out.println();
        System.out.println(repo.getValue(2));
        NoteService noteService = new NoteService(repo);
        System.out.println(noteService.value(2));

    }
}
