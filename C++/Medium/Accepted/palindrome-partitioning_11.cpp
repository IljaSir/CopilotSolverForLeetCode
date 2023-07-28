class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<vector<string>> result;
        vector<string> path;
        dfs(s, 0, path, result);
        return result;
    }
    
    void dfs(string& s, int start, vector<string>& path, vector<vector<string>>& result) {
        if (start == s.size()) {
            result.push_back(path);
            return;
        }
        
        for (int i = start; i < s.size(); ++i) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.push_back(s.substr(start, i - start + 1));
            dfs(s, i + 1, path, result);
            path.pop_back();
        }
    }
    
    bool isPalindrome(string& s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end]) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
};