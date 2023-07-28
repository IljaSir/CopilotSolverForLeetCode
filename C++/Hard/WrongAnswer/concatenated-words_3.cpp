class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        vector<string> res;
        unordered_set<string> dict(words.begin(), words.end());
        for (auto word : words) {
            if (word.empty()) continue;
            int n = word.size();
            vector<bool> dp(n + 1, false);
            dp[0] = true;
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (dp[j] && dict.find(word.substr(j, i - j)) != dict.end()) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (dp[n]) res.push_back(word);
        }
        return res;
    }
};