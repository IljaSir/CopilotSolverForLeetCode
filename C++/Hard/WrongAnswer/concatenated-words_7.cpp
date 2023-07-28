class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        vector<string> res;
        if (words.size() < 2) return res;
        unordered_set<string> dict(words.begin(), words.end());
        for (string word : words) {
            int n = word.size();
            vector<bool> dp(n+1, false);
            dp[0] = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dict.count(word.substr(j, i-j))) {
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