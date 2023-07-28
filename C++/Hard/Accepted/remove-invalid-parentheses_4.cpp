class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> ans;
        int left = 0, right = 0;
        for (auto c : s) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        dfs(s, 0, left, right, ans);
        return ans;
    }
    void dfs(string s, int start, int left, int right, vector<string>& ans) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                ans.push_back(s);
            }
            return;
        }
        for (int i = start; i < s.size(); i++) {
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
    bool isValid(string s) {
        int cnt = 0;
        for (auto c : s) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
};