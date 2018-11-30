import java.util.Arrays;
import java.util.Scanner;

class LongestIncreasingSubseqCount {


    private static int[] textToArray(String s) {
        int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        return numbers;
    }

    static long allSubsIncreasing(int numbers[], int n)
    {
        long counts[] = new long[n];

        for (int i = 0; i < n; i++){
            counts[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    counts[i] += counts[j] % 1000000;
                }
            }
        }

        long longestSubSize = 0;
        for (int i = 0; i < n; i++) {
            longestSubSize += counts[i] % 1000000;
        }

        return longestSubSize;

    }

    public static void main(String[] args)
    {

        Scanner jay = new Scanner(System.in);
        String e = jay.nextLine();
        String s = jay.nextLine();
        int numbers[] = LongestIncreasingSubseqCount.textToArray(s);
        int n = numbers.length;

        long k = allSubsIncreasing(numbers,n) + 1;
        System.out.println(k % 1000000);
    }

}