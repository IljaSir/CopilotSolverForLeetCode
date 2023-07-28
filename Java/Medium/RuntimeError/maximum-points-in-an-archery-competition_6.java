class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[12];
        int[] alicePoints = new int[12];
        int[] bobPoints = new int[12];
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += aliceArrows[i];
            alicePoints[i] = aliceArrows[i] * i;
        }
        for (int i = 0; i < 12; i++) {
            int a = alicePoints[i];
            int b = (sum - aliceArrows[i]) * i;
            if (a > b) {
                bobArrows[i] = aliceArrows[i];
                numArrows -= aliceArrows[i];
            } else {
                bobArrows[i] = 0;
            }
        }
        int i = 0;
        while (numArrows > 0) {
            if (bobArrows[i] < aliceArrows[i]) {
                bobArrows[i]++;
                numArrows--;
            }
            i++;
        }
        return bobArrows;
    }
}