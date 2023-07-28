class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> res;
        string cur;
        dfs(res, cur, 0, 0, n);
        return res;
    }
    void dfs(vector<string> &res, string &cur, int left, int right, int n) {
        if (left == n && right == n) {
            res.push_back(cur);
            return;
        }
        if (left < n) {
            cur.push_back('(');
            dfs(res, cur, left + 1, right, n);
            cur.pop_back();
        }
        if (right < left) {
            cur.push_back(')');
            dfs(res, cur, left, right + 1, n);
            cur.pop_back();
        }
    }
};