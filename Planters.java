import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;

/**
 * Created by ptbud on 9/13/2018.
 */
public class Planters {

    private ArrayList textToArray(ArrayList x, String s){
        String[] splitStrings = s.split(" ");
        for(int i = 0; i < splitStrings.length; i++){
            x.add(Integer.parseInt(splitStrings[i]));
        }
        return x;
    }

    private boolean planting(ArrayList<Integer> p, ArrayList<Integer> r){
        for(int i = 0; i < p.size(); i++){
            for(int j = 0; j < r.size(); j++){
                if(p.get(i) < r.get(j)){
                    Integer swish = p.get(i);
                    Integer bait = r.get(j);
                    p.remove(i);
                    r.remove(j);
                    p.add(i,bait);
                    r.add(j,swish);
                    break;
                }else{
                    if(j == r.size()-1){
                        return false;
                    }
                }
            }


        }
        return true;
    }




    public static void main(String args[]){
        ArrayList<Integer> occupiedPots = new ArrayList<Integer>();
        ArrayList<Integer> newPots = new ArrayList<Integer>();
        int counter = 0;
        int p;
        int r;
        Scanner jay = new Scanner(System.in);
        String s = null;
        String x = null;

        Planters planter = new Planters();

        p = jay.nextInt();
        r = jay.nextInt();

        while(counter < 3){

            if(counter == 0){
                jay.nextLine();
            }
            if(counter == 1){
                s = jay.nextLine();
            }
            if(counter == 2){
                x = jay.nextLine();
            }
            counter++;
        }
        planter.textToArray(occupiedPots,s);
        planter.textToArray(newPots,x);


        sort(occupiedPots);
        sort(newPots);
        reverse(occupiedPots);
        reverse(newPots);
        boolean end = planter.planting(occupiedPots,newPots);
        if(end){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
