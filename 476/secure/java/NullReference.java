public class NullReference {
    public static void main(String[] args) {
        String s = null;
        if(s != null)
            System.out.println(s.length());
        else
            System.out.println("s is null");
    }
}
