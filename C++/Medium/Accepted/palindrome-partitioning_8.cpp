class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<vector<string>> result;
        vector<string> current;
        dfs(0, s, current, result);
        return result;
    }
    
    void dfs(int start, string& s, vector<string>& current, vector<vector<string>>& result) {
        if (start == s.size()) {
            result.push_back(current);
            return;
        }
        
        for (int i = start; i < s.size(); ++i) {
            if (isPalindrome(s, start, i)) {
                current.push_back(s.substr(start, i - start + 1));
                dfs(i + 1, s, current, result);
                current.pop_back();
            }
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