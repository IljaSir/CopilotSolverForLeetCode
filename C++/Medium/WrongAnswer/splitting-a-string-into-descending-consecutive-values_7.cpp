class Solution {
public:
    bool splitString(string s) {
        
        return dfs(s, 0, 0, false);
    }
    bool dfs(string& s, int i, long long pre, bool flag) {
        if (i == s.size()) return flag;
        long long cur = 0;
        for (int j = i; j < s.size(); j++) {
            cur = cur * 10 + s[j] - '0';
            if (cur > pre) break;
            if (cur == pre - 1 && dfs(s, j + 1, cur, true)) return true;
        }
        return false;
    }
};