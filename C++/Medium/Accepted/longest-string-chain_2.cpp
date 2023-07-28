class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        sort(words.begin(), words.end(), [](const string& a, const string& b) {
            return a.size() < b.size();
        });
        int n = words.size();
        unordered_map<string, int> dp;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[words[i]] = 1;
            for (int j = 0; j < words[i].size(); j++) {
                string s = words[i].substr(0, j) + words[i].substr(j + 1);
                if (dp.count(s)) {
                    dp[words[i]] = max(dp[words[i]], 1 + dp[s]);
                }
            }
            ans = max(ans, dp[words[i]]);
        }
        return ans;
    }
};