class Solution {
    public int numRabbits(int[] answers) {
        
        int[] count = new int[1000];
        for (int i : answers) {
            count[i]++;
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                res += (count[i] + i) / (i + 1) * (i + 1);
            }
        }
        return res;
    }
}