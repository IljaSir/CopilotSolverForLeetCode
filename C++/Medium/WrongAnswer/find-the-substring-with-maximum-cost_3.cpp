class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int n = s.size();
        int m = chars.size();
        vector<int> char2val(26, 0);
        for (int i = 0; i < m; ++i) {
            char2val[chars[i] - 'a'] = vals[i];
        }
        vector<int> sum(n, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int val = char2val[s[i] - 'a'];
            if (i == 0) {
                sum[i] = val;
            } else {
                sum[i] = sum[i - 1] + val;
            }
            ans = max(ans, sum[i]);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ans = max(ans, sum[j] - sum[i] + char2val[s[i] - 'a']);
            }
        }
        return ans;
    }
};