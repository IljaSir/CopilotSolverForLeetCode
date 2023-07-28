class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        
        vector<vector<int>> res;
        for (int i = 0; i < rowSum.size(); ++i) {
            vector<int> row;
            for (int j = 0; j < colSum.size(); ++j) {
                int num = min(rowSum[i], colSum[j]);
                row.push_back(num);
                rowSum[i] -= num;
                colSum[j] -= num;
            }
            res.push_back(row);
        }
        return res;
    }
};