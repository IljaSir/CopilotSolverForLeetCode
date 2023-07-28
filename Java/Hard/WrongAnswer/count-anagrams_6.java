class Solution {
    public int countAnagrams(String s) {
        
        int mod = 1000000007;
        int n = s.length();
        int[] f = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                f[s.charAt(i) - 'a']++;
            } else {
                int cnt = 1;
                for (int j = 0; j < 26; j++) {
                    cnt = (int)((long)cnt * factorial[f[j]] % mod);
                    f[j] = 0;
                }
                ans = (ans + cnt) % mod;
            }
        }
        int cnt = 1;
        for (int i = 0; i < 26; i++) {
            cnt = (int)((long)cnt * factorial[f[i]] % mod);
        }
        ans = (ans + cnt) % mod;
        return ans;
    }
    
    int[] factorial = new int[100001];
    
    {
        int mod = 1000000007;
        factorial[0] = 1;
        for (int i = 1; i <= 100000; i++) {
            factorial[i] = (int)((long)factorial[i - 1] * i % mod);
        }
    }
}