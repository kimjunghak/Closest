import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by KJH on 2016-11-02.
 */
public class Closest {

    public void init() throws IOException {
        Input input = new Input();
        ArrayList<Float> temp = input.readClosest();
        ArrayList<Point> arrList = new ArrayList();

        int pos = 0;

        for(int i=0 ; i<temp.size() ; i=i+2)
            arrList.add(pos++, new Point(temp.get(i), temp.get(i+1)));

        System.out.println("closest distance : " + closest_pair(arrList));
    }

    private double closest_pair(ArrayList<Point> arrList){
        int mid = arrList.size()/2;

        if(arrList.size() <= 3)
            return brute_force(arrList);

        Point_Compare_X comp_x = new Point_Compare_X();
        Collections.sort(arrList, comp_x);

        ArrayList<Point> left = new ArrayList<>(arrList.subList(0, mid));
        ArrayList<Point> right = new ArrayList<>(arrList.subList(mid, arrList.size()));

        double min_left = closest_pair(left);
        double min_right = closest_pair(right);
        double min = Math.min(min_left, min_right);

        double window_mid= (arrList.get(mid-1).x + arrList.get(mid+1).x)/2;
        double window_below_range = window_mid - min;
        double window_above_range = window_mid + min;

        int window_start_idx = 0, window_end_idx = 0;
        int below_flag = 0, above_flag = 0;

        for(int i=0 ; i<arrList.size() ; i++){

            if(arrList.get(i).x > window_below_range && below_flag == 1) {
                window_start_idx = i;
                below_flag = 1;
            }

            if((arrList.get(i).x > window_above_range && above_flag == 1)){
                window_end_idx = i-1;
                above_flag = 1;
            }
            else if(i == arrList.size()-1)
                window_end_idx = i;
        }

        ArrayList<Point> window = new ArrayList<>(arrList.subList(window_start_idx, window_end_idx+1));
        Point_Compare_Y comp_y = new Point_Compare_Y();
        Collections.sort(window, comp_y);
        double window_dis = brute_force(window);

        min = Math.min(min, window_dis);

        return min;
    }

    private double brute_force(ArrayList<Point> arrList){
        double min_dis = Double.MAX_VALUE;
        for(int i=0 ; i<arrList.size() ; i++){
            for(int j=i+1 ; j<arrList.size() ; j++){
                double dis = distance(arrList.get(i), arrList.get(j));
                if(dis < min_dis)
                    min_dis = dis;
            }
        }
        return min_dis;
    }

    private double distance(Point dot1, Point dot2){
        double distance =  Math.sqrt(Math.pow(Math.abs(dot1.x - dot2.x), 2) + Math.pow(Math.abs(dot1.y - dot2.y), 2));
        return distance;
    }


}
