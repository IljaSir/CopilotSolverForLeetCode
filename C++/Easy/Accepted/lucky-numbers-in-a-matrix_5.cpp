class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        vector<int> result;
        int m = matrix.size();
        int n = matrix[0].size();
        for(int i = 0; i < m; i++){
            int min = INT_MAX;
            int minIndex = 0;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            bool isMax = true;
            for(int k = 0; k < m; k++){
                if(matrix[k][minIndex] > min){
                    isMax = false;
                }
            }
            if(isMax){
                result.push_back(min);
            }
        }
        return result;
    }
};