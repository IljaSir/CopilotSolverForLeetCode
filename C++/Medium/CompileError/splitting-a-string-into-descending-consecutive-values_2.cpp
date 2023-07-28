class Solution {
public:
    bool splitString(string s) {
        
        int n = s.length();
        for (int i = 1; i < n; i++) {
            long long num = stoll(s.substr(0, i));
            if (dfs(s, i, num)) {
                return true;
            }
        }
        return false;
    }
};