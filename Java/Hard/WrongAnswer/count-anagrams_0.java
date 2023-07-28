class Solution {
    public int countAnagrams(String s) {
        
        int MOD = 1000000007;
        int n = s.length();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % MOD);
        }
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                int total = 1;
                for (int j = 0; j < 26; j++) {
                    total = (int) ((long) total * fact[count[j]] % MOD);
                }
                res = (res + total) % MOD;
                count = new int[26];
            } else {
                count[s.charAt(i) - 'a']++;
            }
        }
        int total = 1;
        for (int j = 0; j < 26; j++) {
            total = (int) ((long) total * fact[count[j]] % MOD);
        }
        res = (res + total) % MOD;
        return res;
    }
}