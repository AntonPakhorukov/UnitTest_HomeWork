public class NoteService {
    private NoteBookRepository noteBookRepository;

    public NoteService(NoteBookRepository noteBookRepository) {
        this.noteBookRepository = noteBookRepository;
    }

    public void edit(int id, Note newNote) {
        this.noteBookRepository.editNote(id, newNote);
    }
    public void delete(int id){
        this.noteBookRepository.deleteNote(id);
    }
    public void add(Note newNote){
        this.noteBookRepository.addNote(newNote);
    }
    public String value(int id) {
        for (int i = 1; i < this.noteBookRepository.size() + 1; i++) {
            if (i == id) {
                return String.valueOf(this.noteBookRepository.getValue(i));
            }
        }
        return null;
    }
}
