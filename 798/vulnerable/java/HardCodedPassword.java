public class HardCodedPassword {
    public static void main(String[] args) {
        if (verifyPassword(args[0])) {
            System.out.println("Password Verified");
        } else {
            System.out.println("Incorrect Password");
        }
    }

    private boolean verifyPassword(String password) {
        if (password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}