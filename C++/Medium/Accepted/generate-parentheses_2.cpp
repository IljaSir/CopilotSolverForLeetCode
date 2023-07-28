class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> result;
        generateParenthesis(result, "", 0, 0, n);
        return result;
    }
    void generateParenthesis(vector<string>& result, string str, int open, int close, int max) {
        if (str.length() == max * 2) {
            result.push_back(str);
            return;
        }
        if (open < max) {
            generateParenthesis(result, str + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParenthesis(result, str + ")", open, close + 1, max);
        }
    }
};