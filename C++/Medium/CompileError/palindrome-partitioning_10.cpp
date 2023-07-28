class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        int n = s.size();
        vector<vector<string>> result;
        vector<string> path;
        dfs(s, 0, n, result, path);
        return result;
    }
    void dfs(string s, int start, int n, vector<vector<string>>& result, vector<string>& path) {
        if (start == n) {
            result.push_back(path);
            return;
        }
        for (int i = start; i < n; ++i) {
            if (isPalindrome(s, start, i)) {
                path.push_back(s.substr(start, i - start + 1));
                dfs(s, i + 1, n, result, path);
                path.pop_back();
            }
        }
    }
    bool isPalindrome(string s, int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--]) {
                return false;
            };
    }
    void dfs(string& s, vector<vector<string>>& res, vector<string>& path, int start) {
        if (start == s.size()) {
            res.push_back(path);
            return;
        }
        for (int i = start; i < s.size(); i++) {
            if (!isPalindrome(s, start, i)) continue;
            path.push_back(s.substr(start, i - start + 1));
            dfs(s, res, path, i + 1);
            path.pop_back();
        }
    }
    bool isPalindrome(string& s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) return false;
            l++; r--;
        }
        return true;
    }
};