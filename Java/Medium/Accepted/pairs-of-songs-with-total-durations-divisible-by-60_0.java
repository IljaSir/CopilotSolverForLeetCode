class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] count = new int[60];
        int res = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                res += count[0];
            } else {
                res += count[60 - t % 60];
            }
            count[t % 60]++;
        }
        return res;
    }
}