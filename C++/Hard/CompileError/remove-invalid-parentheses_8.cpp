class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> res;
        string path;
        int left = 0, right = 0;
        for (char& c : s) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        dfs(s, 0, left, right, 0, path, res);
        return res;
    }
};