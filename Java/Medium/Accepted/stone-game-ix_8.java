class Solution {
    public boolean stoneGameIX(int[] stones) {
        
        int[] bucket = new int[3];
        for (int stone : stones) {
            bucket[stone % 3]++;
        }
        if (bucket[0] % 2 == 0) {
            return bucket[1] > 0 && bucket[2] > 0;
        } else {
            return Math.abs(bucket[1] - bucket[2]) > 2;
        }
    }
}