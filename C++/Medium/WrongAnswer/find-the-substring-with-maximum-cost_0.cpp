class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int n = s.size();
        int m = chars.size();
        vector<int> cnt(26, 0);
        for (int i = 0; i < m; ++i) {
            cnt[chars[i] - 'a'] = vals[i];
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < n && cnt[s[j] - 'a'] != 0) {
                sum += cnt[s[j] - 'a'];
                ++j;
            }
            ans = max(ans, sum);
            sum -= cnt[s[i] - 'a'];
        }
        return ans;
    }
};