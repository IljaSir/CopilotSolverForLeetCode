class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        
        vector<vector<int>> result(rowSum.size(), vector<int>(colSum.size(), 0));
        for (int i = 0; i < rowSum.size(); ++i) {
            for (int j = 0; j < colSum.size(); ++j) {
                result[i][j] = min(rowSum[i], colSum[j]);
                rowSum[i] -= result[i][j];
                colSum[j] -= result[i][j];
            }
        }
        return result;
    }
};