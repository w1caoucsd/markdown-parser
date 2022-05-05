import java.util.ArrayList;

public class arraylistTest{
    
    public static void main(String[] args) {
        ArrayList<Object> listOfObj=new ArrayList<>();
        listOfObj.add(new Integer(2));
        listOfObj.add(new String("hi"));
        System.out.println(listOfObj.toString());
    }
}