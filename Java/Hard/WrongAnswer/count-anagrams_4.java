class Solution {
    public int countAnagrams(String s) {
        
        int mod = 1000000007;
        int n = s.length();
        int[] f = new int[26];
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                int cnt = 0;
                for (int j = 0; j < 26; j++) {
                    if (f[j] > 0) {
                        cnt += f[j];
                        f[j] = 0;
                    }
                }
                res = (int) ((long) res * factorial(cnt) % mod);
            } else {
                f[s.charAt(i) - 'a']++;
            }
        }
        int cnt = 0;
        for (int j = 0; j < 26; j++) {
            if (f[j] > 0) {
                cnt += f[j];
                f[j] = 0;
            }
        }
        res = (int) ((long) res * factorial(cnt) % mod);
        return res;
    }

    int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = (int) ((long) res * i % 1000000007);
        }
        return res;
    }
}