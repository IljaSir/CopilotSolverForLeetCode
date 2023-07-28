class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] mod60 = new int[60];
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % 60;
            if (mod == 0) {
                count += mod60[mod];
            } else {
                count += mod60[60 - mod];
            }
            mod60[mod]++;
        }
        return count;
    }
}