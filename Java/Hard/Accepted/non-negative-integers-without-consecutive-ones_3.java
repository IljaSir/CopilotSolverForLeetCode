class Solution {
    public int findIntegers(int n) {
        
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int res = 0, k = 30, pre_bit = 0;
        while (k >= 0) {
            if (((n >> k) & 1) > 0) {
                res += f[k];
                if (pre_bit > 0) {
                    res--;
                    break;
                }
                pre_bit = 1;
            } else {
                pre_bit = 0;
            }
            k--;
        }
        return res + 1;
    }
}