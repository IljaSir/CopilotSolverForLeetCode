class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] bobArrows = new int[12];
        int total = 0;
        for (int i = 0; i < 12; i++) {
            bobArrows[i] = numArrows - aliceArrows[i];
            total += bobArrows[i] * i;
        }
        int max = total;
        int[] res = bobArrows.clone();
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 12; j++) {
                if (i == j) continue;
                int diff = (i - j) * (aliceArrows[j] - bobArrows[j]);
                if (diff > 0) {
                    total -= diff;
                    bobArrows[i]--;
                    bobArrows[j]++;
                }
            }
            if (total > max) {
                max = total;
                res = bobArrows.clone();
            }
        }
        return res;
    }
}