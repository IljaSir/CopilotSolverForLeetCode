class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> res;
        if (n == 0) {
            res.push_back("");
            return res;
        }
        for (int i = 0; i < n; ++i) {
            vector<string> left = generateParenthesis(i);
            vector<string> right = generateParenthesis(n - i - 1);
            for (auto l : left) {
                for (auto r : right) {
                    res.push_back("(" + l + ")" + r);
                }
            }
        }
        return res;
    }
};