class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int c : cnt) {
            if (c % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(n - i - 1);
            if (c1 == c2) {
                continue;
            }
            int d1 = c1 - 'a';
            int d2 = c2 - 'a';
            if (cnt[d1] > cnt[d2]) {
                ans += cnt[d2];
                cnt[d1] -= cnt[d2];
                cnt[d2] = 0;
            } else {
                ans += cnt[d1];
                cnt[d2] -= cnt[d1];
                cnt[d1] = 0;
            }
        }
        if (n % 2 == 1) {
            ans += odd / 2;
        }
        return ans;
    }
}