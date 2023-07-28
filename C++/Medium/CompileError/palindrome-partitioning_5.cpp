class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<vector<string>> res;
        vector<string> path;
        dfs(s, 0, path, res);
        return res;
    }
};