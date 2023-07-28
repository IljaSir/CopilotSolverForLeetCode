class Solution {
    public int numRabbits(int[] answers) {
        
        int[] counts = new int[1000];
        for (int i : answers) {
            counts[i]++;
        }
        int res = 0;
        for (int i = 0; i < 1000; i++) {
            if (counts[i] > 0) {
                res += (i + 1) * (counts[i] / (i + 1) + (counts[i] % (i + 1) > 0 ? 1 : 0));
            }
        }
        return res;
    }
}