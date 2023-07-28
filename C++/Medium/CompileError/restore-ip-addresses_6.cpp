class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        
        vector<string> res;
        int n = s.size();
        if (n < 4 || n > 12)
            return res;
        string path;
        dfs(s, 0, 0, path, res);
        return res;
    }
};