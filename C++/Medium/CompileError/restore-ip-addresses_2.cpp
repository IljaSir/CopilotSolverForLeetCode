class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        
        vector<string> result;
        string ip;
        dfs(s, 0, 0, ip, result);
        return result;
    }
};