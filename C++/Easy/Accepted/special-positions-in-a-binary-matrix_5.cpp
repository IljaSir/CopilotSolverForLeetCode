class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> r(m, 0);
        vector<int> c(n, 0);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && r[i] == 1 && c[j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
};