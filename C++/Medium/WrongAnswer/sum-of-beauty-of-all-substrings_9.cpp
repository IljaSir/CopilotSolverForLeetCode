class Solution {
public:
    int beautySum(string s) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            vector<int> cnt(26);
            int mx = 0, mn = INT_MAX;
            for (int j = i; j < n; ++j) {
                ++cnt[s[j] - 'a'];
                mx = max(mx, cnt[s[j] - 'a']);
                mn = min(mn, cnt[s[j] - 'a']);
                ans += mx - mn;
            }
        }
        return ans;
    }
};