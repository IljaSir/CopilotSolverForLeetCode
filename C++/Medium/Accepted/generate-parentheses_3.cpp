class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> res;
        string s;
        helper(n, 0, 0, s, res);
        return res;
    }
    void helper(int n, int left, int right, string s, vector<string>& res) {
        if (left == n && right == n) {
            res.push_back(s);
            return;
        }
        if (left < n) {
            helper(n, left + 1, right, s + "(", res);
        }
        if (right < left) {
            helper(n, left, right + 1, s + ")", res);
        }
    }
};