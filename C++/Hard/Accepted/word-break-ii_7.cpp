class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        int maxLen = 0;
        for (const string &word : wordDict) {
            maxLen = max(maxLen, (int)word.length());
        }
        vector<vector<string>> dp(s.length() + 1);
        dp[0].emplace_back();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && i - j <= maxLen; j--) {
                if (dp[j].empty()) {
                    continue;
                }
                string word = s.substr(j, i - j);
                if (dict.count(word)) {
                    for (const string &prev : dp[j]) {
                        dp[i].emplace_back(prev + (prev.empty() ? "" : " ") + word);
                    }
                }
            }
        }
        return dp.back();
    }
};