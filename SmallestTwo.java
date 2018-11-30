import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;

/**
 * Created by ptbud on 9/7/2018.
 */
public class SmallestTwo {

    private ArrayList getNumbers(){
        Scanner jay = new Scanner(System.in);

        ArrayList r = new ArrayList();
        System.out.println("How big do you want the array to be?");
        int size = jay.nextInt();
        System.out.println("Enter your numbers: ");
        for(int i = 0; i<size;i++){
            int input = jay.nextInt();
            r.add(input);
        }
        sort(r);
        return r;
    }




    public static void main(String[] args){
        SmallestTwo smallestTwo = new SmallestTwo();
        ArrayList sorted = smallestTwo.getNumbers();
        for(int i = 0; i<2; i++){
            System.out.println(sorted.get(i));
        }


    }

}
