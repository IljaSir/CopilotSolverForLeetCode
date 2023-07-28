class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        
        int k = original.size();
        if (m * n != k) return {};
        vector<vector<int>> res(m, vector<int>(n));
        for (int i = 0; i < k; ++i) {
            res[i / n][i % n] = original[i];
        }
        return res;
    }
};