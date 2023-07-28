class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> words;
        for (auto& word: wordDict) {
            words.insert(word);
        }
        vector<vector<int>> dp(s.size() + 1);
        dp[0].push_back(0);
        for (int i = 1; i <= s.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j].size() > 0 && words.find(s.substr(j, i - j)) != words.end()) {
                    dp[i].push_back(j);
                }
            }
        }
        vector<string> ans;
        if (dp[s.size()].size() > 0) {
            vector<string> path;
            dfs(s, s.size(), dp, path, ans);
        }
        return ans;
    }
    
    void dfs(string& s, int i, vector<vector<int>>& dp, vector<string>& path, vector<string>& ans) {
        if (i == 0) {
            string str;
            for (int i = path.size() - 1; i >= 0; --i) {
                str += path[i];
                if (i > 0) {
                    str += " ";
                }
            }
            ans.push_back(str);
            return;
        }
        for (auto j: dp[i]) {
            path.push_back(s.substr(j, i - j));
            dfs(s, j, dp, path, ans);
            path.pop_back();
        }
    }
};