class Solution {
public:
    vector<string> generateParenthesis(int n) {
        
        vector<string> result;
        if (n == 0) {
            return result;
        }
        dfs(n, n, "", result);
        return result;
    }
};