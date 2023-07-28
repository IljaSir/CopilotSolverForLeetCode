class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] map = new int[60];
        int count = 0;
        for (int t : time) {
            int r = t % 60;
            count += map[(60 - r) % 60];
            map[r]++;
        }
        return count;
    }
}