class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        vector<vector<string>> dp(s.size() + 1);
        dp[0].push_back("");
        for (int i = 1; i <= s.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j].size() > 0 && dict.count(s.substr(j, i - j))) {
                    for (string str : dp[j]) {
                        dp[i].push_back(str + (str == "" ? "" : " ") + s.substr(j, i - j));
                    }
                }
            }
        }
        return dp[s.size()];
    }
};