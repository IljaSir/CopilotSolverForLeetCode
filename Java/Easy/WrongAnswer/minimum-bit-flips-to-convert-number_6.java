class Solution {
    public int minBitFlips(int start, int goal) {
        
        int count = 0;
        int n = 0;
        for (int i = 0; i < 32; i++) {
            if (((start & 1) ^ (goal & 1)) == 1) {
                count++;
                n = i;
            }
            start >>= 1;
            goal >>= 1;
        }
        if (n == 0) {
            return 0;
        }
        return (count + n - 1) / n;
    }
}