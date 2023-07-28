class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int res = 0;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1) count++;
            }
        }
        if(count == 0) return 0;
        if(count == m*n) return 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    res = max(res, 1 + minFlips(mat, i, j));
                }
            }
        }
        return res;
    }
    int minFlips(vector<vector<int>>& mat, int i, int j){
        int m = mat.size();
        int n = mat[0].size();
        int res = 0;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1) count++;
            }
        }
        if(count == 0) return 0;
        if(count == m*n) return 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    res = max(res, 1 + minFlips(mat, i, j));
                }
            }
        }
        return res;
    }
    int minFlips(vector<vector<int>>& mat, int i, int j, int m, int n){
        int res = 0;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1) count++;
            }
        }
        if(count == 0) return 0;
        if(count == m*n) return 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    res = max(res
    }
};