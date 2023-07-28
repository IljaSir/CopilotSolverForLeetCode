class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[aliceArrows.length];
        for (int i = 0; i < aliceArrows.length; i++) {
            bobArrows[i] = numArrows - aliceArrows[i];
        }
        bobArrows[11] -= numArrows / 2;
        return bobArrows;
    }
}