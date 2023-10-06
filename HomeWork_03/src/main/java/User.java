public class User {
    String name;
    String password;
    boolean isAuthenticate = false;
    private boolean isAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
    }
    public boolean authenticate(String name, String password){
        this.isAuthenticate = this.name.equals(name) && this.password.equals(password);
        return this.isAuthenticate;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        if (isAuthenticate){
            isAdmin = admin;
        }
    }

    @Override
    public String toString() {
        return name + " " + password + " LogIn: " + isAuthenticate + " Admin: " + isAdmin;
    }
}
