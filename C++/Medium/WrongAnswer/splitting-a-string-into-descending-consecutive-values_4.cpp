class Solution {
public:
    bool splitString(string s) {
        
        return dfs(s, 0, -1);
    }
    
    bool dfs(string s, int start, long prev) {
        if (start == s.size()) return true;
        long cur = 0;
        for (int i = start; i < s.size(); i++) {
            cur = cur * 10 + s[i] - '0';
            if (cur > INT_MAX) return false;
            if (prev == -1 || prev == cur + 1) {
                if (dfs(s, i + 1, cur)) return true;
            }
        }
        return false;
    }
};