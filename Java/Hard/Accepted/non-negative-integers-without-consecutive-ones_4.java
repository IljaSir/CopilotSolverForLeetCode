class Solution {
    public int findIntegers(int n) {
        
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int ans = 0;
        int k = 30;
        int preBit = 0;
        while (k >= 0) {
            if (((n >> k) & 1) == 1) {
                ans += f[k];
                if (preBit == 1) {
                    ans--;
                    break;
                }
                preBit = 1;
            } else {
                preBit = 0;
            }
            k--;
        }
        return ans + 1;
    }
}