class Solution {
    public int numRabbits(int[] answers) {
        
        int[] count = new int[1000];
        for (int answer : answers) {
            count[answer]++;
        }
        int res = 0;
        for (int i = 0; i < 1000; i++) {
            res += count[i] / (i + 1) * (i + 1);
            if (count[i] % (i + 1) != 0) {
                res += i + 1;
            }
        }
        return res;
    }
}