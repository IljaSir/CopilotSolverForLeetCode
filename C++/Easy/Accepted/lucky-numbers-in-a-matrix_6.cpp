class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> res;
        for(int i = 0; i < m; ++i){
            int min_val = INT_MAX;
            int min_idx = -1;
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] < min_val){
                    min_val = matrix[i][j];
                    min_idx = j;
                }
            }
            bool is_lucky = true;
            for(int k = 0; k < m; ++k){
                if(matrix[k][min_idx] > min_val){
                    is_lucky = false;
                    break;
                }
            }
            if(is_lucky){
                res.push_back(min_val);
            }
        }
        return res;
    }
};