class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<    return;> result;
        vector<string>
        }
        for (int i = start; i < s.size(); i++) {
            if (!isPalindrome(s, start, i)) continue;
            path.push_back(s.substr(start, i - start + 1));
            dfs(s, i + 1, path, res);
            path.pop_back();
        }
    }
    bool isPalindrome(string s, int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--]) return false;
        }
        return true;
    }
};