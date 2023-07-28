class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[] leftToRight = new int[k];
        int[] rightToLeft = new int[k];
        int[] pickOld = new int[k];
        int[] putNew = new int[k];
        for (int i = 0; i < k; i++) {
            leftToRight[i] = time[i][0];
            pickOld[i] = time[i][1];
            rightToLeft[i] = time[i][2];
            putNew[i] = time[i][3];
        }
        int[] leftToRightIndex = new int[k];
        int[] rightToLeftIndex = new int[k];
        for (int i = 0; i < k; i++) {
            leftToRightIndex[i] = i;
            rightToLeftIndex[i] = i;
        }
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (leftToRight[i] + rightToLeft[i] > leftToRight[j] + rightToLeft[j]) {
                    int tmp = leftToRight[i];
                    leftToRight[i] = leftToRight[j];
                    leftToRight[j] = tmp;
                    tmp = leftToRightIndex[i];
                    leftToRightIndex[i] = leftToRightIndex[j];
                    leftToRightIndex[j] = tmp;
                } else if (leftToRight[i] + rightToLeft[i] == leftToRight[j] + rightToLeft[j] && i > j) {
                    int tmp = leftToRight[i];
                    leftToRight[i] = leftToRight[j];
                    leftToRight[j] = tmp;
                    tmp = leftToRightIndex[i];
                    leftToRightIndex[i] = leftToRightIndex[j];
                    leftToRightIndex[j] = tmp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (rightToLeft[i] + leftToRight[i] > rightToLeft[j] + leftToRight[j]) {
                    int tmp = rightToLeft[i];
                    rightToLeft[i] = rightToLeft[j];
                    rightToLeft[j] = tmp;
                    tmp = rightToLeftIndex[i];
                    rightToLeftIndex[i] = rightToLeftIndex[j];
                    rightToLeftIndex[j] =
    }
}