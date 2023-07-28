class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        vector<int> res;
        int m = matrix.size();
        int n = matrix[0].size();
        for(int i=0; i<m; i++){
            int min = matrix[i][0];
            int minIdx = 0;
            for(int j=1; j<n; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minIdx = j;
                }
            }
            bool flag = true;
            for(int k=0; k<m; k++){
                if(matrix[k][minIdx] > min){
                    flag = false;
                    break;
                }
            }
            if(flag) res.push_back(min);
        }
        return res;
    }
};