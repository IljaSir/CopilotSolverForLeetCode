class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int n = s.size();
        int m = chars.size();
        vector<int> cost(n, 0);
        for (int i = 0; i < n; ++i) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                cost[i] = s[i] - 'a' + 1;
            } else {
                for (int j = 0; j < m; ++j) {
                    if (s[i] == chars[j]) {
                        cost[i] = vals[j];
                        break;
                    }
                }
            }
        }
        int ans = 0;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < n; ++r) {
            sum += cost[r];
            ans = max(ans, sum);
            if (sum < 0) {
                sum = 0;
                l = r + 1;
            }
        }
        return ans;
    }
};