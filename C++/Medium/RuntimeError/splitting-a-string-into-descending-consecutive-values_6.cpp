class Solution {
public:
    bool splitString(string s) {
        
        int n = s.size();
        if (n < 2) return false;
        for (int i = 1; i < n; i++) {
            int num = stoi(s.substr(0, i));
            if (dfs(s, i, num)) return true;
        }
        return false;
    }
    bool dfs(string& s, int i, int pre) {
        int n = s.size();
        if (i == n) return true;
        for (int j = i + 1; j <= n; j++) {
            int cur = stoi(s.substr(i, j - i));
            if (cur != pre - 1) continue;
            if (dfs(s, j, cur)) return true;
        }
        return false;
    }
};