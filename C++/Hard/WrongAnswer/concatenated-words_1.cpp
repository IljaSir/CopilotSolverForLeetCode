class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        unordered_set<string> dict;
        for (const string& word : words) {
            dict.insert(word);
        }
        vector<string> res;
        for (const string& word : words) {
            int n = word.size();
            vector<bool> dp(n + 1, false);
            dp[0] = true;
            for (int i = 0; i < n; ++i) {
                if (!dp[i]) {
                    continue;
                }
                for (int j = i + 1; j <= n; ++j) {
                    if (dict.count(word.substr(i, j - i)) && j != n) {
                        dp[j] = true;
                    }
                }
                if (dp[n]) {
                    res.push_back(word);
                    break;
                }
            }
        }
        return res;
    }
};