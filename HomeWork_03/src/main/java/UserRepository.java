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
    public void logOut() {
        for (User user : data) {
            if(!user.isAdmin()) {
                user.isAuthenticate = false;
            }
        }
    }
    public int size(){
        return data.size();
    }
}
