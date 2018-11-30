import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ptbud on 9/6/2018.
 */

public class Primes {

    private int getInput(){

        Scanner jay = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = jay.nextInt();

        return x;
    }

    private ArrayList<Integer> getOutputs(int x){

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int isPrime;

        for(int i = 0; i <= x; i++){
            isPrime = 0;
            if(i != 0 && i != 1){
                if(i == 2){
                    primeNumbers.add(i);
                }else{
                    for(int j = 0; j<primeNumbers.size(); j++){
                        if(i % primeNumbers.get(j) == 0){
                            isPrime++;
                        }
                    }
                    if(isPrime == 0){
                        primeNumbers.add(i);
                    }
                }
            }
        }
        return primeNumbers;
    }

    public static void main(String[] args){
        Primes prime = new Primes();
        int input = prime.getInput();

        ArrayList<Integer> outputs = prime.getOutputs(input);
        for(int i = 0; i < outputs.size(); i++){
            System.out.println(outputs.get(i));
        }
    }
}
