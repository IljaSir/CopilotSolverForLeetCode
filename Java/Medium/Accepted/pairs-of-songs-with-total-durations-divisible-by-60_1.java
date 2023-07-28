class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] counts = new int[60];
        int count = 0;
        for (int t : time) {
            count += counts[(60 - t % 60) % 60];
            counts[t % 60]++;
        }
        return count;
    }
}