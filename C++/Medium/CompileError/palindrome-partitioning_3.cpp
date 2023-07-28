class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<vector<string>> res;
        vector<string> path;
        dfs(s, 0, path, res);
        return res;
    }
    void dfs(string s, int start, vector<string> &path, vector<vector<string>> &res) {
        if (start == s.size()) {
            res.push_back(path);;
        vector<string> path;
        dfs(s, res, path, 0);
        retrn res;
    }
    void dfs(string& s, vector<vector<string>>& res, vector<string>& path, int start) {
        if (start == s.size()) {
            res.push_back(path);
            return;
        }
        for (int i = start; i < s.size(); i++) {
            if (!isPaindrome(s, start, i)) continue;
            path.push_back(s.substr(start, i - start + 1));
            dfs(s, res, path, i + 1);
            pah.pop_back()
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