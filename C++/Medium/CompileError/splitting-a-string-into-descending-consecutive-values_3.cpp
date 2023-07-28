class Solution {
public:
    bool splitString(string s) {
        
        int n = s.size();
        for (int i = 1; i < n; ++i) {
            long long val = stoll(s.substr(0, i));
            if (dfs(s.substr(i), val - 1)) {
                return true;
            }
        }
        return false;
    }
};