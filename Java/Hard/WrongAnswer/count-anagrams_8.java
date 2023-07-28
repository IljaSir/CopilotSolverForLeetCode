class Solution {
    public int countAnagrams(String s) {
        
        int MOD = 1000000007;
        int n = s.length();
        int ans = 1;
        int[] cnt = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == ' ') {
                int sum = 0;
                for (int j = 0; j < 26; ++j) {
                    sum += cnt[j];
                    cnt[j] = 0;
                }
                ans = (int)((long)ans * fact(sum) % MOD);
            } else {
                ++cnt[s.charAt(i) - 'a'];
            }
        }
        int sum = 0;
        for (int j = 0; j < 26; ++j) {
            sum += cnt[j];
            cnt[j] = 0;
        }
        ans = (int)((long)ans * fact(sum) % MOD);
        return ans;
    }
    int fact(int x) {
        int ans = 1;
        for (int i = 1; i <= x; ++i) {
            ans = (int)((long)ans * i % 1000000007);
        }
        return ans;
    }
}