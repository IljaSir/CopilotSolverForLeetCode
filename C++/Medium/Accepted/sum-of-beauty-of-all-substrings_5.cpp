class Solution {
public:
    int beautySum(string s) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            vector<int> cnt(26);
            for (int j = i; j < n; j++) {
                cnt[s[j] - 'a']++;
                int mn = 500, mx = 0;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        mn = min(mn, cnt[k]);
                        mx = max(mx, cnt[k]);
                    }
                }
                ans += mx - mn;
            }
        }
        return ans;
    }
};