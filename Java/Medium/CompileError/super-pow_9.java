class Solution {
    public int superPow(int a, int[] b) {
        
        if (a == 1) return 1;
        if (a == 2) return ((b[b.length - 1] & 1) == 1) ? 2 : 6;
        int mod = 1337;
        int ans = 1;
        for (int i = 0; i < b.length; i++) {
            ans = pow(ans, 10, mod) * pow(a, b[i], mod) % mod;
        }
        return ans;
    }
}