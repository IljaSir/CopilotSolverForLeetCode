class Solution {
public:
    int largestVariance(string s) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int mx = 0, mn = n;
                for (int k = 0; k < 26; ++k) {
                    int c = cnt[j][k] - (i > 0 ? cnt[i - 1][k] : 0);
                    if (c > 0) {
                        mx = max(mx, c);
                        mn = min(mn, c);
                    }
                }
                ans = max(ans, mx - mn);
            }
        }
        return ans;
    }
};