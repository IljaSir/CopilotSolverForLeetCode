class Solution {
public:
    vector<vector<int>> reconstructMatrix(int upper, int lower, vector<int>& colsum) {
        
        vector<vector<int>> res(2, vector<int>(colsum.size(), 0));
        for (int i = 0; i < colsum.size(); ++i) {
            if (colsum[i] == 2) {
                res[0][i] = 1;
                res[1][i] = 1;
                --upper;
                --lower;
            }
        }
        
        if (upper < 0 || lower < 0) {
            return {};
        }
        
        for (int i = 0; i < colsum.size(); ++i) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    res[0][i] = 1;
                    --upper;
                } else if (lower > 0) {
                    res[1][i] = 1;
                    --lower;
                } else {
                    return {};
                }
            }
        }
        
        if (upper != 0 || lower != 0) {
            return {};
        }
        
        return res;
    }
};