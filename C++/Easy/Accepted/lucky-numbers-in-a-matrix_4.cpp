class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        vector<int> res;
        int m = matrix.size();
        int n = matrix[0].size();
        int min = 0;
        int max = 0;
        for(int i = 0; i < m; i++){
            min = 0;
            for(int j = 1; j < n; j++){
                if(matrix[i][j] < matrix[i][min]){
                    min = j;
                }
            }
            max = 0;
            for(int j = 1; j < m; j++){
                if(matrix[j][min] > matrix[max][min]){
                    max = j;
                }
            }
            if(max == i){
                res.push_back(matrix[i][min]);
            }
        }
        return res;
    }
};