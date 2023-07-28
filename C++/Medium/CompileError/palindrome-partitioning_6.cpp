class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<vector<string>> res;
        vector<string> path;
        dfs(s, res, path, 0);
        return res
        }
        return true;
    }
};