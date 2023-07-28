class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] count = new int[60];
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            res += count[(60 - t) % 60];
            count[t]++;
        }
        return res;
    }
}