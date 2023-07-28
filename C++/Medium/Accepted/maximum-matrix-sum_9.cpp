class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int min = 100000;
        long long sum = 0;
        int negative = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] < 0){
                    negative++;
                }
                if(abs(matrix[i][j]) < min){
                    min = abs(matrix[i][j]);
                }
                sum += abs(matrix[i][j]);
            }
        }
        if(negative % 2 == 0){
            return sum;
        }else{
            return sum - 2 * min;
        }
    }
};