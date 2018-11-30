import java.util.Scanner;
class IntervalsBreaks {
    private static int NUM = 0;
    private static int[][] merge(int[][] a, int[][] b) {
        int[][] c = new int[a.length + b.length][2];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if      (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i][1] <= b[j][1])  c[k] = a[i++];
            else                    c[k] = b[j++];
        }
        return c;
    }
    public static int[][] mergeSort(int[][] input) {
        int N = input.length;
        if (N <= 1) return input;
        int[][] x = new int[N/2][2];
        int[][] y = new int[N - N/2][2];
        for (int i = 0; i < x.length; i++)
            x[i] = input[i];
        for (int i = 0; i < y.length; i++)
            y[i] = input[i + N/2];
        return merge(mergeSort(x), mergeSort(y));
    }
    public static boolean doesOverlap(int[][] sorted, int[][] breaksList, int j, int k) {
        int end = sorted[k][1] + breaksList[sorted[k][2]][sorted[j][2]];
        //if my end time is before your start time
        return end > sorted[j][0];
    }
    private static int findMaxIntervals(int[][] sorted, int[][] breaksList){
        int[] S = new int[NUM+1];
        S[0] = 1;
        for (int j = 0 ; j <NUM; j++) {
            int k = j;
            while (k >= 0 && doesOverlap(sorted, breaksList, j, k)) {
                k--;
            }
            if (k < 0) {
                S[j+1] = Math.max(S[j], 1);
            } else {
                S[j+1] = Math.max(S[j], S[k+1] + 1);
            }
        }
        return S[NUM];
    }
    public static void main(String[] args) {
        Scanner jay = new Scanner(System.in);
        NUM = Integer.parseInt(jay.nextLine());
        int intervals[][] = new int[NUM][3];
        for (int i = 0; i < NUM; i++) {
            String[] pointPair = jay.nextLine().split(" ");
            intervals[i][0] = Integer.parseInt(pointPair[0]);
            intervals[i][1] = Integer.parseInt(pointPair[1]);
            intervals[i][2] = i;
        }
        int breaksList[][] = new int[NUM][NUM];
        for (int i = 0; i < NUM; i++) {
            String[] breaks = jay.nextLine().split(" ");
            for (int c = 0; c < NUM; c++) {
                breaksList[i][c] = Integer.parseInt(breaks[c]);
            }
        }
        int[][] sorted = mergeSort(intervals);
        System.out.println(findMaxIntervals(sorted, breaksList));
    }
}
