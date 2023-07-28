class Solution {
public:
    int beautySum(string s) {
        
        int ans = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            int cnt[26] = {0};
            for (int j = i; j < n; ++j) {
                ++cnt[s[j] - 'a'];
                int mx = 0, mn = n + 1;
                for (int k = 0; k < 26; ++k) {
                    if (cnt[k]) {
                        mx = max(mx, cnt[k]);
                        mn = min(mn, cnt[k]);
                    }
                }
                ans += mx - mn;
            }
        }
        return ans;
    }
};