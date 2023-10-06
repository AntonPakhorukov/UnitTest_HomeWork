import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        data.add(user);
    }
    public void deleteUser(User user){
        data.remove(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }
    public List<User> logOut() {
        List<User> repoAdmin = new ArrayList<>();
        for (User user : data) {
            if(user.isAdmin()) {
                repoAdmin.add(user);
            }
        }
        this.data = repoAdmin;
        return this.data;
    }
    public int size(){
        return data.size();
    }
}
