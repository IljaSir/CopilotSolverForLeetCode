class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<vector<string>> res;
        vector<string> path;
        dfs(res, path, s, 0);
        return res;
    }
    void dfs(vector<vector<string>>& res, vector<string>& path, string& s, int start) {
        if (start == s.size()) {
            res.push_back(path);
            return;
        }
        for (int i = start; i < s.size(); i++) {
            if (!isPalindrome(s, start, i)) continue;
            path.push_back(s.substr(start, i - start + 1));
            dfs(res, path, s, i + 1);
            path.pop_back();
        }
    }
    bool isPalindrome(string& s, int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--]) return false;
        }
        return true;
    }
};