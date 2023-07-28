class Solution {
    public int minBitFlips(int start, int goal) {
        
        int n = 0;
        int count = 0;
        while (start > 0 || goal > 0) {
            int s = start & 1;
            int g = goal & 1;
            if (s == g) {
                n = 0;
            } else if (n == 0) {
                n = 1;
                count++;
            } else {
                n = 0;
            }
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }
}