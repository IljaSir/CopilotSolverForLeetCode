class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> result;
        string str;
        generateParenthesisHelper(n, n, str, result);
        return result;
    }
    
    void generateParenthesisHelper(int left, int right, string str, vector<string>& result) {
        if (left == 0 && right == 0) {
            result.push_back(str);
            return;
        }
        if (left > 0) {
            generateParenthesisHelper(left - 1, right, str + "(", result);
        }
        if (right > left) {
            generateParenthesisHelper(left, right - 1, str + ")", result);
        }
    }
};