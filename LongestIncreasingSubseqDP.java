import java.util.Scanner;

public class LongestIncreasingSubseqDP {


    private static void getNumbers(){
        Scanner jay = new Scanner(System.in);
        int n = Integer.parseInt(jay.nextLine());
        int numbers[] = new int[n];
        String[] s = jay.nextLine().split(" ");
        for (int i = 0; i < n-1 ; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }
        System.out.println(subSeq(numbers, n));
    }

    private static int subSeq(int numbers[], int n){
        int longest[] = new int[n];

        int max = 0;

        for (int i = 0; i < n ; i++) {
            longest[i] = 1;
        }

        for(int i =1; i< n; i++){
            for (int j = 0; j < i ; j++) {
                if (numbers[i] > numbers[j] && longest[i] < longest[j] +1){
                    longest[i] = longest[j] +1;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            if (max < longest[i]){
                max = longest[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        getNumbers();
    }
}