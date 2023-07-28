class Solution {
    public int numRabbits(int[] answers) {
        
        int[] count = new int[1000];
        for (int answer : answers) {
            count[answer]++;
        }
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            ans += (count[i] + i) / (i + 1) * (i + 1);
        }
        return ans;
    }
}