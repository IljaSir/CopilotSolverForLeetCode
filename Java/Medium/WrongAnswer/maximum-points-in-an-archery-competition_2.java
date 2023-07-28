class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[12];
        int[] alicePoints = new int[12];
        int[] bobPoints = new int[12];
        int aliceTotal = 0;
        int bobTotal = 0;
        for (int i = 0; i < 12; i++) {
            alicePoints[i] = aliceArrows[i] * i;
            aliceTotal += alicePoints[i];
        }
        int max = 0;
        int[] result = new int[12];
        for (int i = 0; i < 12; i++) {
            int total = aliceTotal - alicePoints[i];
            int bobPointsI = Math.min(numArrows, aliceArrows[i] + 1) * i;
            total += bobPointsI;
            if (total > max) {
                max = total;
                result[i] = Math.min(numArrows, aliceArrows[i] + 1);
                for (int j = 0; j < 12; j++) {
                    if (j == i) {
                        continue;
                    }
                    result[j] = aliceArrows[j];
                }
            }
        }
        return result;
    }
}