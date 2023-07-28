class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        
        vector<vector<vector<double>>> dp(n, vector<vector<double>>(n, vector<double>(k+1, 0)));
        return helper(n, k, row, column, dp);
    }
};