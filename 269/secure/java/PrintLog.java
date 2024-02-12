public class PrintLog {
    public enum Roles {
        ADMIN, USER, GUEST
    }
        
    public void printDebugInfo(User requestingUser){
        if(isAuthenticated(requestingUser)){
            switch(requestingUser.role){
            // 
            case ADMIN:
            case USER:
                System.out.println(currentDebugState());
            break;
            
            // Make default case as unauthorized user
            default:
                System.out.println("You are not authorized to perform this command");
                break;
            }
        } else {
            System.out.println("You must be logged in to perform this command");
        }
    }
}