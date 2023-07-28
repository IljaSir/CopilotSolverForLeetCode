class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> result;
        if (n <= 0) return result;
        string temp;
        generateParenthesisCore(n, 0, 0, temp, result);
        return result;
    }
    void generateParenthesisCore(int n, int left, int right, string& temp, vector<string>& result) {
        if (left == n && right == n) {
            result.push_back(temp);
            return;
        }
        if (left < n) {
            temp.push_back('(');
            generateParenthesisCore(n, left + 1, right, temp, result);
            temp.pop_back();
        }
        if (right < left) {
            temp.push_back(')');
            generateParenthesisCore(n, left, right + 1, temp, result);
            temp.pop_back();
        }
    }
};