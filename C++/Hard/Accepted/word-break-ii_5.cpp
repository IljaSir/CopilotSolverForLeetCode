class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        vector<vector<string>> dp(s.size() + 1);
        dp[0].emplace_back("");
        for (int i = 1; i <= s.size(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (!dp[j].empty() && dict.count(s.substr(j, i - j))) {
                    for (auto &str : dp[j]) {
                        dp[i].emplace_back(str + (str.empty() ? "" : " ") + s.substr(j, i - j));
                    }
                }
            }
        }
        return dp[s.size()];
    }
};