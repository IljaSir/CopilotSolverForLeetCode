class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        vector<int> res;
        int m = matrix.size();
        int n = matrix[0].size();
        for(int i = 0; i < m; i++){
            int min = INT_MAX;
            int min_j = 0;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    min_j = j;
                }
            }
            int max = INT_MIN;
            for(int k = 0; k < m; k++){
                if(matrix[k][min_j] > max){
                    max = matrix[k][min_j];
                }
            }
            if(max == min){
                res.push_back(min);
            }
        }
        return res;
    }
};