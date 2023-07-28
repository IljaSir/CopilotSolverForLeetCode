class Solution {
    public long sumScores(String s) {
        
        int n = s.length();
        long[] pows = new long[n];
        long[] hashes = new long[n];
        long[] invs = new long[n];
        long[] invpows = new long[n];
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        long[] invprefix = new long[n];
        long[] invsuffix = new long[n];
        long mod = 1000000007;
        long base = 31;
        pows[0] = 1;
        invpows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = pows[i - 1] * base % mod;
            invpows[i] = invpows[i - 1] * inv(base, mod) % mod;
        }
        hashes[0] = s.charAt(0) - 'a' + 1;
        invs[0] = s.charAt(0) - 'a' + 1;
        for (int i = 1; i < n; i++) {
            hashes[i] = (hashes[i - 1] * base + s.charAt(i) - 'a' + 1) % mod;
            invs[i] = (invs[i - 1] * base + s.charAt(n - i - 1) - 'a' + 1) % mod;
        }
        prefix[0] = hashes[0];
        invprefix[0] = invs[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = (prefix[i - 1] + hashes[i] * pows[i]) % mod;
            invprefix[i] = (invprefix[i - 1] + invs[i] * pows[i]) % mod;
        }
        suffix[0] = hashes[n - 1];
        invsuffix[0] = invs[n - 1];
        for (int i = 1; i < n; i++) {
            suffix[i] = (suffix[i - 1] + hashes[n - i - 1] * pows[i]) % mod;
            invsuffix[i] = (invsuffix[i - 1] + invs[n - i - 1] * pows[i
    }
}