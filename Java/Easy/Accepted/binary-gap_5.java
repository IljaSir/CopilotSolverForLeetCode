class Solution {
    public int binaryGap(int n) {
        
        int max = 0;
        int last = -1;
        int idx = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    max = Math.max(max, idx - last);
                }
                last = idx;
            }
            n >>= 1;
            idx++;
        }
        return max;
    }
}