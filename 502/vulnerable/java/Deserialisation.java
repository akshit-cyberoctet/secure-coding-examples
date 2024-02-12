public class Deserialisation {
    public static void main(String[] args) {
        try {
            File file = new File("object.obj");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            javax.swing.JButton button = (javax.swing.JButton) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}