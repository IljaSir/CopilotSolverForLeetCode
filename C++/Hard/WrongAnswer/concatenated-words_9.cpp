class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        vector<string> result;
        for (auto &word : words) {
            if (word.empty()) continue;
            int n = word.size();
            vector<bool> dp(n+1, false);
            dp[0] = true;
            for (int i = 1; i <= n; ++i) {
                for (int j = i-1; j >= 0; --j) {
                    if (dp[j] && find(words.begin(), words.end(), word.substr(j, i-j)) != words.end()) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (dp[n]) result.push_back(word);
        }
        return result;
    }
};