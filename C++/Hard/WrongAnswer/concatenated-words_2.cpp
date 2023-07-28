class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        unordered_set<string> wordSet(words.begin(), words.end());
        vector<string> res;
        for (string& word : words) {
            int n = word.size();
            vector<bool> dp(n + 1, false);
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (!dp[j]) continue;
                    if (wordSet.count(word.substr(j, i - j))) {
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