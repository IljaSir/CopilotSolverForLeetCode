class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[aliceArrows.length];
        int[] alicePoints = new int[aliceArrows.length];
        int[] bobPoints = new int[aliceArrows.length];
        int aliceTotal = 0;
        int bobTotal = 0;
        for(int i = 0; i < aliceArrows.length; i++) {
            alicePoints[i] = aliceArrows[i] * i;
            aliceTotal += alicePoints[i];
        }
        for(int i = 0; i < aliceArrows.length; i++) {
            bobArrows[i] = Math.min(numArrows, aliceArrows[i] + 1);
            bobPoints[i] = bobArrows[i] * i;
            bobTotal += bobPoints[i];
            numArrows -= bobArrows[i];
        }
        if(bobTotal > aliceTotal) return bobArrows;
        for(int i = aliceArrows.length - 1; i >= 0; i--) {
            if(bobArrows[i] > 0) {
                bobArrows[i]--;
                bobPoints[i] -= i;
                bobTotal -= i;
                numArrows++;
                if(bobTotal > aliceTotal) return bobArrows;
            }
        }
        return bobArrows;
    }
}