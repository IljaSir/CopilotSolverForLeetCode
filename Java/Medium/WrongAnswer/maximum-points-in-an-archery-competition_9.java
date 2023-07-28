class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[12];
        int[] aliceArrowsCopy = aliceArrows.clone();
        Arrays.sort(aliceArrowsCopy);
        int[] bobArrowsCopy = new int[12];
        int[] aliceArrowsCopy2 = aliceArrows.clone();
        int[] bobArrowsCopy2 = new int[12];
        for (int i = 11; i >= 0; i--) {
            bobArrowsCopy[i] = numArrows - aliceArrowsCopy[i];
            numArrows = aliceArrowsCopy[i];
        }
        numArrows = aliceArrowsCopy2[0];
        for (int i = 1; i < 12; i++) {
            bobArrowsCopy2[i] = numArrows - aliceArrowsCopy2[i];
            numArrows = aliceArrowsCopy2[i];
        }
        int alicePoints = 0;
        int bobPoints = 0;
        for (int i = 0; i < 12; i++) {
            alicePoints += aliceArrows[i] * i;
            bobPoints += bobArrowsCopy[i] * i;
        }
        if (alicePoints > bobPoints) {
            return bobArrowsCopy;
        }
        else {
            return bobArrowsCopy2;
        }
    }
}