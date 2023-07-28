class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] map = new int[60];
        int count = 0;
        for (int t : time) {
            int mod = t % 60;
            int pair = (60 - mod) % 60;
            count += map[pair];
            map[mod]++;
        }
        return count;
    }
}