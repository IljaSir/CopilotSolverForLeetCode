class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> ret;
        string s;
        dfs(ret, s, 0, 0, n);
        return ret;
    }

    void dfs(vector<string> &ret, string &s, int l, int r, int n) {
        if (l == n && r == n) {
            ret.push_back(s);
            return;
        }
        if (l < n) {
            s.push_back('(');
            dfs(ret, s, l + 1, r, n);
            s.pop_back();
        }
        if (r < l) {
            s.push_back(')');
            dfs(ret, s, l, r + 1, n);
            s.pop_back();
        }
    }
};