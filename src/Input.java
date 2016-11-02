import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

    public ArrayList readInversion() throws IOException {
        FileInputStream input_Inversion = new FileInputStream("C:/Users/KJH/IdeaProjects/Closest/src/data07_inversion.txt");
        //FileInputStream input = new FileInputStream("/home/kjh/Documents/git/InsertionSort/sort/src/data02.txt");
        StringBuffer buffer = new StringBuffer();
        ArrayList<Integer> arrList = new ArrayList();

        int data;
        while( (data = input_Inversion.read()) != -1){
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

    public ArrayList readClosest() throws IOException {
        BufferedReader closest = new BufferedReader(new FileReader("C:/Users/KJH/IdeaProjects/Closest/src/data07_closest.txt"));

        ArrayList<Float> arrList = new ArrayList();
        String[] point;
        while(true) {
            String line = closest.readLine();
            if (line==null) break;

            point = line.split(",");

            for(int i=0 ; i<point.length ; i++)
                arrList.add(convertToFloat(point[i]));
        }
        closest.close();
        return arrList;
    }

    public int convertToInt(Object obj){
        return Integer.parseInt(obj.toString());
    }

    public float convertToFloat(Object obj) { return Float.parseFloat(obj.toString()) ;   }
}