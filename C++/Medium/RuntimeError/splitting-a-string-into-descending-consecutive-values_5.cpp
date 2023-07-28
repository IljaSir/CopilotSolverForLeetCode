class Solution {
public:
    bool splitString(string s) {
        
        int n = s.size();
        for (int i = 1; i < n; i++) {
            string t = s.substr(0, i);
            long long num = stoll(t);
            if (dfs(s, i, num - 1)) return true;
        }
        return false;
    }
    bool dfs(string& s, int i, long long num) {
        if (i == s.size()) return true;
        for (int j = i + 1; j <= s.size(); j++) {
            string t = s.substr(i, j - i);
            long long n = stoll(t);
            if (n == num && dfs(s, j, num - 1)) return true;
        }
        return false;
    }
};