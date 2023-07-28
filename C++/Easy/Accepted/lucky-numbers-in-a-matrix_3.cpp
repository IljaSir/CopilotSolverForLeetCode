class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        vector<int> result;
        for(int i = 0; i < matrix.size(); i++) {
            int min = matrix[i][0];
            int index = 0;
            for(int j = 1; j < matrix[i].size(); j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    index = j;
                }
            }
            bool isLucky = true;
            for(int j = 0; j < matrix.size(); j++) {
                if(matrix[j][index] > min) {
                    isLucky = false;
                    break;
                }
            }
            if(isLucky) {
                result.push_back(min);
            }
        }
        return result;
    }
};