import java.util.Scanner;

public class MaxRectanglePerimeter {
    static int nums;

    private void textToCoords() {
        Scanner scanner = new Scanner(System.in);
        nums = Integer.parseInt(scanner.nextLine());
        int numList[][] = new int[nums][2];
        for (int i = 0; i < nums; i++) {
            String[] coords = scanner.nextLine().split(" ");
            numList[i][0] = Integer.parseInt(coords[0]);
            numList[i][1] = Integer.parseInt(coords[1]);
        }
        findAreas(numList);



    }

    private void findAreas(int[][] numList){
        int sum = 0;
        int height = 0;
        int width = 0;
        for (int i = 1; i < nums-3; i = i + 2) {
            boolean lowerexists = true;
            //this loop only looks at horizontal sections
            int c = i + 2;
            while (numList[c][1] >= numList[i][1]) {
                c = c + 2;
                if (c >= nums) {
                    int leftwall = numList[i][0];
                    lowerexists = false;
                    if (numList[i][1] < numList[i - 1][1]) {
                        //was on a descending wall, and thus should extend left
                        for (int j = i - 3; j > -1; j = j - 2) {
                            if (numList[j][1] < numList[i][1]) {
                                leftwall = numList[j][0];
                                break;
                            }
                        }
                    }
                    height = numList[i][1];
                    width = numList[nums - 1][0] - leftwall;
                    if (sum < 2*height + 2*width) {
                        sum = Math.max(sum, 2*height + 2*width);
                    }
                    break;
                }
            }
            //if here, lower was found
            int leftwall = numList[i][0];
            if (lowerexists == true) {
                //determine if it is on a left wall, or where the left wall should be
                if (numList[i][1] < numList[i - 1][1]) {
                    //was on a descending wall, and thus should extend left
                    for (int j = i - 3; j > -1; j = j - 2) {
                        if (numList[j][1] < numList[i][1]) {
                            leftwall = numList[j][0];
                            break;
                        }
                    }
                }
                height = numList[i][1];
                width = numList[c][0] - leftwall;
                if (sum < 2*height + 2*width) {
                    sum = Math.max(sum, 2*height + 2*width);
                }

            }


        }
        //check last horizontal against whole
        int i = nums-3;
        int leftwall = numList[i][0];
        if (numList[i][1] < numList[i - 1][1]) {
            //was on a descending wall, and thus should extend left
            for (int j = i - 3; j > -1; j = j - 2) {
                if (numList[j][1] < numList[i][1]) {
                    leftwall = numList[j][0];
                    break;
                }
            }
        }
        height = numList[i][1];
        width = numList[nums - 1][0] - leftwall;
        if (sum < 2*height + 2*width) {
            sum = Math.max(sum, 2*height + 2*width);
        }
        System.out.println(sum);
    }

    public static void main(String[] args){
        MaxRectanglePerimeter MaxRectanglePerimeter = new MaxRectanglePerimeter();

        MaxRectanglePerimeter.textToCoords();
    }
}