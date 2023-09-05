import java.util.ArrayList;
import java.util.Arrays;

public class Memory {

    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();
        try {
            while (true){
                list.add(253435252);
            }
        }
        catch (OutOfMemoryError error){
            System.out.println(error.getMessage());
            System.out.println(error.getStackTrace());
            System.out.println(error.getLocalizedMessage());
            error.printStackTrace();
            System.out.println("working");
        }

    }
}
