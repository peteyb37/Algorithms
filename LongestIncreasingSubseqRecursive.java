import java.util.Scanner;

public class LongestIncreasingSubseqRecursive {

    static int max;

    private static void getNumbers(){
        Scanner jay = new Scanner(System.in);
        int n = Integer.parseInt(jay.nextLine());
        int numbers[] = new int[n];
        String[] s = jay.nextLine().split(" ");
        for (int i = 0; i < n-1 ; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }
        longest(numbers,n);
    }



    private static int increasingSubSeqRecursive(int numbers[], int n)
    {
        if (n == 1){
            return 1;
        }

        int curr;
        int maxEnd = 1;
        for (int i = 1; i < n; i++)
        {
            curr = increasingSubSeqRecursive(numbers, i);
            if (numbers[i-1] < numbers[n-1] && curr + 1 > maxEnd) {
                maxEnd = curr + 1;
            }
        }
        if (max < maxEnd) {
            max = maxEnd;
        }

        return maxEnd;
    }


    static int longest(int numbers[], int n){
        max = 1;
        increasingSubSeqRecursive(numbers, n);
        return max;
    }

    public static void main(String[] args){
        getNumbers();
        System.out.println(max);
    }


}