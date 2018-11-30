import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ptbud on 11/29/2018.
 */
public class WeightedByDiffInversions {

    private ArrayList textToArray(ArrayList x, String s){
        String[] splitStrings = s.split(" ");
        for(int i = 0; i < splitStrings.length; i++){
            x.add(Long.parseLong(splitStrings[i]));
        }
        return x;
    }

    private void recurrence (ArrayList<Long> x){
        long current = 0;
        long sum = 0;

        for(int i = 0; i < x.size(); i++){
            current = x.get(i);
            for(int j = i+1; j < x.size(); j++){
                if(current > x.get(j)){
                    sum += (current-x.get(j));
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String args[]){
        WeightedByDiffInversions weights = new WeightedByDiffInversions();
        ArrayList<Long> numbers = new ArrayList<Long>();

        int n = 0;
        Scanner jay = new Scanner(System.in);
        String s;

        n = Integer.parseInt(jay.nextLine());
        s = jay.nextLine();
        weights.textToArray(numbers,s);
        weights.recurrence(numbers);
    }

}
