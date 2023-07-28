class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int ans = 0;
        int n = s.length();
        int m = chars.length();
        for (int i = 0; i < n; ++i) {
            int cost = 0;
            int cnt[26] = {};
            for (int j = i; j < n; ++j) {
                int index = s[j] - 'a';
                if (cnt[index] == 0) {
                    for (int k = 0; k < m; ++k) {
                        if (chars[k] == s[j]) {
                            cost += vals[k];
                            cnt[index] = 1;
                            break;
                        }
                    }
                }
                ans = max(ans, cost);
            }
        }
        return ans;
    }
};