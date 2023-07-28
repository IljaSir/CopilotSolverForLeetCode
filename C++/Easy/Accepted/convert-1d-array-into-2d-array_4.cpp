class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        
        int len = original.size();
        if (len != m * n) return {};
        vector<vector<int>> res;
        for (int i = 0; i < m; i++) {
            vector<int> tmp;
            for (int j = 0; j < n; j++) {
                tmp.push_back(original[i * n + j]);
            }
            res.push_back(tmp);
        }
        return res;
    }
};