class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> res;
        string s = "";
        helper(n, n, s, res);
        return res;
    }
    void helper(int left, int right, string& s, vector<string>& res) {
        if (left == 0 && right == 0) {
            res.push_back(s);
            return;
        }
        if (left > 0) {
            s.push_back('(');
            helper(left - 1, right, s, res);
            s.pop_back();
        }
        if (right > 0 && right > left) {
            s.push_back(')');
            helper(left, right - 1, s, res);
            s.pop_back();
        }
    }
};