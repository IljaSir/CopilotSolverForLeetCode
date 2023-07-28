class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[12];
        int[] target = new int[12];
        for (int i = 0; i < 12; i++) {
            target[i] = i;
        }
        int[] alicePoints = new int[12];
        int[] bobPoints = new int[12];
        for (int i = 0; i < 12; i++) {
            alicePoints[i] = target[i] * aliceArrows[i];
            bobPoints[i] = target[i] * (numArrows - aliceArrows[i]);
        }
        int total = 0;
        for (int i = 0; i < 12; i++) {
            total += alicePoints[i];
        }
        int max = 0;
        for (int i = 0; i < 12; i++) {
            if (alicePoints[i] < bobPoints[i]) {
                max += bobPoints[i];
                bobArrows[i] = numArrows - aliceArrows[i];
            }
        }
        if (max < total) {
            return aliceArrows;
        }
        return bobArrows;
    }
}