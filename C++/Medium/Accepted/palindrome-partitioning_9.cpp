class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        int n = s.length();
        vector<vector<string>> res;
        vector<string> path;
        dfs(s, 0, n, res, path);
        return res;
    }
    
    void dfs(string s, int start, int n, vector<vector<string>>& res, vector<string>& path) {
        if (start == n) {
            res.push_back(path);
            return;
        }
        for (int i = start; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                path.push_back(s.substr(start, i - start + 1));
                dfs(s, i + 1, n, res, path);
                path.pop_back();
            }
        }
    }
    
    bool isPalindrome(string s, int low, int high) {
        while (low < high) {
            if (s[low] != s[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
};