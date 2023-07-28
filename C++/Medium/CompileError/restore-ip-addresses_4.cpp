class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        
        vector<string> result;
        string path;
        dfs(s, 0, 0, path, result);
        return result;
    }
};