class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] mod = new int[60];
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            int c = (60 - t) % 60;
            count += mod[c];
            mod[t]++;
        }
        return count;
    }
}