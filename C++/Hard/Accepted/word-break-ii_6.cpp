class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> wordSet;
        for (auto word : wordDict) {
            wordSet.insert(word);
        }
        vector<bool> dp(s.size() + 1, false);
        dp[0] = true;
        for (int i = 1; i <= s.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.find(s.substr(j, i - j)) != wordSet.end()) {
                    dp[i] = true;
                    break;
                }
            }
        }
        vector<string> res;
        if (dp[s.size()]) {
            vector<string> path;
            dfs(s, s.size(), wordSet, dp, path, res);
        }
        return res;
    }
    
    void dfs(string& s, int size, unordered_set<string>& wordSet, vector<bool>& dp, vector<string>& path, vector<string>& res) {
        if (size == 0) {
            string tmp = path.back();
            path.pop_back();
            for (int i = path.size() - 1; i >= 0; i--) {
                tmp += " " + path[i];
            }
            res.push_back(tmp);
            path.push_back(tmp);
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (dp[i] && wordSet.find(s.substr(i, size - i)) != wordSet.end()) {
                path.push_back(s.substr(i, size - i));
                dfs(s, i, wordSet, dp, path, res);
                path.pop_back();
            }
        }
    }
};