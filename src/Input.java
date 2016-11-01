import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

    public ArrayList readFile() throws IOException {
        FileInputStream input = new FileInputStream("C:/Users/KJH/IdeaProjects/Closest/src/data07_inversion.txt");
        //FileInputStream input = new FileInputStream("/home/kjh/Documents/git/InsertionSort/sort/src/data02.txt");
        StringBuffer buffer = new StringBuffer();
        ArrayList<Integer> arrList = new ArrayList();
        int data;

        while( (data = input.read()) != -1){
            if( data == ',') {
                arrList.add(convertToInt(buffer));
                buffer.setLength(0);
            }
            else
                buffer.append((char)data);
        }
        arrList.add(convertToInt(buffer));
        return arrList;
    }

    public int convertToInt(Object obj){
        return Integer.parseInt(obj.toString());
    }
}