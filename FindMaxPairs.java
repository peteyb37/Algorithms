import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;

/**
 * Created by ptbud on 9/14/2018.
 */
public class FindMaxPairs {

    private ArrayList textToArray(ArrayList x, String s){
        String[] splitStrings = s.split(" ");
        for(int i = 0; i < splitStrings.length; i++){
            x.add(Integer.parseInt(splitStrings[i]));
        }
        return x;
    }

    private ArrayList<Integer> initArrays(int max){
        ArrayList<Integer> x = new ArrayList<Integer>(max);
        for(int i = 0; i <= max; i++){
            x.add(0);
        }
        return x;
    }

    private void fillTheList(ArrayList x, ArrayList y, ArrayList neg){
        int current = 0;
        int count = 0;

        for(int i = 0; i < x.size(); i ++){
            for(int j = i+1; j < x.size(); j++){
                current = (int) x.get(i) + (int) x.get(j);
                if(current<0){
                    count = (int) neg.get(current * -1);
                    count+=1;
                    neg.set(current*-1, count);
                }else{
                    count = (int) y.get(current);
                    count+=1;
                    y.set(current, count);
                }





            }
        }
        int r = highestNumber(y);
        int l = highestNumber(neg);
        if(r > l){
            System.out.println(r);
        }else{
            System.out.println(l*-1);
        }
        //System.out.println(highestNumber(y));

    }

    private int highestNumber(ArrayList x){

        int count = 0;
        int index = 0;

        for(int i = 0; i < x.size(); i++){
            if((int) x.get(i) > count){
                count = (int) x.get(i);
                index = i;
            }
        }
        return index;
    }




    public static void main(String args[]){
        FindMaxPairs finder = new FindMaxPairs();
        ArrayList<Integer> allNumbers = new ArrayList<>();

        int n;
        int max;
        int min;
        int high;
        Scanner jay = new Scanner(System.in);
        int counter = 0;
        String s = null;

        n = jay.nextInt();
        while(counter < 2) {

            if (counter == 0) {
                jay.nextLine();
            }
            if (counter == 1) {
                s = jay.nextLine();
            }
            counter++;
        }
        finder.textToArray(allNumbers, s);
        sort(allNumbers);
        min = allNumbers.get(0)+allNumbers.get(0);
        reverse(allNumbers);
        max = allNumbers.get(0)+allNumbers.get(0);
        if(min*-1 > max){
            high = min*-1;
        }else{
            high = max;
        }
        ArrayList<Integer> empties = finder.initArrays(high);
        ArrayList<Integer> Negempties = finder.initArrays(high);
        finder.fillTheList(allNumbers,empties,Negempties);

    }
}
