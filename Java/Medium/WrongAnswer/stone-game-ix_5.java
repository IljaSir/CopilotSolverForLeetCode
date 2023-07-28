class Solution {
    public boolean stoneGameIX(int[] stones) {
        
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        if (count[1] == 0 || count[2] == 0) {
            return count[0] % 2 == 0;
        }
        return Math.min(count[1], count[2]) % 2 == 1;
    }
}