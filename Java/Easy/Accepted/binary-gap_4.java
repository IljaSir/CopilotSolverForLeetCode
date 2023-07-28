class Solution {
    public int binaryGap(int n) {
        
        int max = 0;
        int last = -1;
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (last >= 0) {
                    max = Math.max(max, bit-last);
                }
                last = bit;
            }
            bit++;
            n >>= 1;
        }
        return max;
    }
}