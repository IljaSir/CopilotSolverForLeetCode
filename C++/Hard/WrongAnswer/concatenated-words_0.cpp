class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        unordered_set<string> dict(words.begin(), words.end());
        vector<string> res;
        for (string& word : words) {
            int n = word.size();
            vector<int> dp(n + 1);
            dp[0] = 1;
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (dp[j] && dict.count(word.substr(j, i - j))) {
                        dp[i] = 1;
                        break;
                    }
                }
            }
            if (dp[n]) res.push_back(word);
        }
        return res;
    }
};