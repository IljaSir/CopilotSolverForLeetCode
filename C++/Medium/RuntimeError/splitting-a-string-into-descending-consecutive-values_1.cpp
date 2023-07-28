class Solution {
public:
    bool splitString(string s) {
        
        int n = s.size();
        for (int i = 1; i < n; i++) {
            long long num = stoll(s.substr(0, i));
            if (dfs(s, i, num - 1)) return true;
        }
        return false;
    }
    
    bool dfs(string& s, int i, long long num) {
        if (i == s.size()) return true;
        for (int j = i + 1; j <= s.size(); j++) {
            long long cur = stoll(s.substr(i, j - i));
            if (cur == num && dfs(s, j, num - 1)) return true;
        }
        return false;
    }
};