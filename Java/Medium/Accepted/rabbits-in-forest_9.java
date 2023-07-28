class Solution {
    public int numRabbits(int[] answers) {
        
        int[] count = new int[1000];
        for(int a : answers) {
            count[a]++;
        }
        int res = 0;
        for(int i = 0; i < 1000; i++) {
            if(count[i] > 0) {
                res += (i + 1) * ((count[i] + i) / (i + 1));
            }
        }
        return res;
    }
}