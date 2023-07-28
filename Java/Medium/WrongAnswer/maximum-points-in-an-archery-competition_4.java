class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[12];
        int[] alicePoints = new int[12];
        int aliceTotal = 0;
        int bobTotal = 0;
        for (int i = 0; i < aliceArrows.length; i++) {
            aliceTotal += aliceArrows[i] * i;
            alicePoints[i] = aliceArrows[i] * i;
        }
        int max = 0;
        int[] maxArr = new int[12];
        for (int i = 0; i < alicePoints.length; i++) {
            for (int j = 0; j < alicePoints.length; j++) {
                if (i == j) continue;
                int temp = alicePoints[i] + alicePoints[j];
                int[] tempArr = new int[12];
                tempArr[i] = aliceArrows[i];
                tempArr[j] = aliceArrows[j];
                for (int k = 0; k < aliceArrows.length; k++) {
                    if (k == i || k == j) continue;
                    tempArr[k] = numArrows - aliceArrows[i] - aliceArrows[j];
                }
                if (temp > max) {
                    max = temp;
                    maxArr = tempArr;
                }
            }
        }
        return maxArr;
    }
}