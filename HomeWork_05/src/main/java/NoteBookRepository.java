import org.mockito.internal.matchers.Not;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteBookRepository implements EditNote {
    private Map<Integer, Note> notes;

    public NoteBookRepository() {
        this.notes = new HashMap<>();
    }

    @Override
    public void editNote(int id, Note newNote) {
        this.notes.put(id, newNote);
    }

    @Override
    public void deleteNote(int id) {
        this.notes.remove(id);
    }

    @Override
    public void addNote(Note newNote) {
        this.notes.put(notes.size() + 1, newNote);
    }

    @Override
    public String toString() {
        return "Notes: "  + notes ;

    }
    public int size() {
        return this.notes.size();
    }
    public String getValue(int id) {
        for (int i = 1; i < this.notes.size() + 1; i++) {
            if (i == id) {
                return String.valueOf(this.notes.get(i));
            }
        }
        return null;
    }
}
