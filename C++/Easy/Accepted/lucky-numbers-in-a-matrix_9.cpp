class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        vector<int> ans;
        int n = matrix.size();
        int m = matrix[0].size();
        for(int i=0; i<n; i++){
            int min = 100000;
            int minIndex = 0;
            for(int j=0; j<m; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            int max = 0;
            for(int k=0; k<n; k++){
                if(matrix[k][minIndex] > max){
                    max = matrix[k][minIndex];
                }
            }
            if(max == min){
                ans.push_back(max);
            }
        }
        return ans;
    }
};