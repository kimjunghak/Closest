import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KJH on 2016-11-01.
 */
public class Inversion_count {

    public void count_inversion() throws IOException {
        Input input = new Input();
        ArrayList arrList = input.readFile();
        Inversion result = sort_and_count(arrList);
        print(result);
    }

    private Inversion sort_and_count(ArrayList<Integer> arrList){
        int length = arrList.size();

        if(length < 2)
            return new Inversion(0, arrList);

        int middle = length / 2;

        ArrayList leftList = new ArrayList(arrList.subList(0, middle));
        ArrayList rightList = new ArrayList(arrList.subList(middle, arrList.size()));

        Inversion left = sort_and_count(leftList);
        Inversion right = sort_and_count(rightList);

        Inversion result = merge_and_count(left, right);

        result.count = result.count + left.count + right.count;

        return result;
    }

    private Inversion merge_and_count(Inversion left, Inversion right) {
        int inversion_count = 0;

        ArrayList<Integer> List = new ArrayList();

        while(left.inversion.size() != 0 && right.inversion.size() != 0){
            if(left.inversion.get(0) > right.inversion.get(0)) {
                inversion_count = inversion_count + left.inversion.size();
                List.add(right.inversion.remove(0));
            }
            else {
                List.add(left.inversion.remove(0));
            }
        }

        List.addAll(left.inversion);
        List.addAll(right.inversion);

        return new Inversion(inversion_count, List);
    }

    public void print(Inversion result){
        System.out.println("Inversion count : "+result.count);
        System.out.print("List : ");
        for(int i=0;i<result.inversion.size() ; i++){
            if(i != 0 && i != result.inversion.size())
                System.out.print(", ");
            System.out.print(result.inversion.get(i));
        }
    }
}
