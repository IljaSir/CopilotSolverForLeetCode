class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[12];
        int[] aliceArrowsCopy = aliceArrows.clone();
        int total = 0;
        for (int i = 11; i >= 0; i--) {
            total += aliceArrows[i];
            if (total > numArrows) {
                aliceArrowsCopy[i] -= total - numArrows;
                total = numArrows;
            }
        }
        for (int i = 0; i < 12; i++) {
            bobArrows[i] = aliceArrowsCopy[i] + (total - aliceArrows[i]) / 2;
        }
        return bobArrows;
    }
}