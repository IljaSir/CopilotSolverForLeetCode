class Solution {
    public boolean stoneGameIX(int[] stones) {
        
        int[] count = new int[3];
        for (int i = 0; i < stones.length; i++) {
            count[stones[i] % 3]++;
        }
        if (count[0] % 2 == 1) {
            return count[1] > 0 && count[2] > 0;
        } else {
            return Math.abs(count[1] - count[2]) >= 3;
        }
    }
}