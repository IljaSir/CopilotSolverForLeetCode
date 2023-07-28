class Solution {
    public int minBitFlips(int start, int goal) {
        
        int[] bits = new int[32];
        int[] bits2 = new int[32];
        int i = 0;
        while (start > 0) {
            bits[i++] = start % 2;
            start /= 2;
        }
        i = 0;
        while (goal > 0) {
            bits2[i++] = goal % 2;
            goal /= 2;
        }
        int ans = 0;
        for (int j = 0; j < 32; j++) {
            if (bits[j] == bits2[j]) {
                continue;
            }
            if (bits[j] == 0) {
                ans++;
                bits[j] = 1;
            }
            if (bits[j] == 1) {
                ans++;
                bits[j] = 0;
            }
        }
        return ans;
    }
}