class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        int left = 0;
        int right = 0;
        for (char ch : s) {
            if (ch == '(') {
                ++left;
            } else if (ch == ')') {
                if (left > 0) {
                    --left;
                } else {
                    ++right;
                }
            }
        }
        vector<string> ans;
        dfs(s, 0, left, right, ans);
        return ans;
    }
    
    void dfs(const string &s, int start, int left, int right, vector<string> &ans) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                ans.emplace_back(s);
            }
            return;
        }
        for (int i = start; i < s.size(); ++i) {
            if (i > start && s[i] == s[i - 1]) {
                continue;
            }
            if (s[i] == '(') {
                dfs(s.substr(0, i) + s.substr(i + 1), i, left - 1, right, ans);
            } else if (s[i] == ')') {
                dfs(s.substr(0, i) + s.substr(i + 1), i, left, right - 1, ans);
            }
        }
    }
    
    bool isValid(const string &s) {
        int left = 0;
        for (char ch : s) {
            if (ch == '(') {
                ++left;
            } else if (ch == ')') {
                if (left > 0) {
                    --left;
                } else {
                    return false;
                }
            }
        }
        return left == 0;
    }
};