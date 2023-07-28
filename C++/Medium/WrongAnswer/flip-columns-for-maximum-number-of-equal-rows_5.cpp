class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        int res = 0;
        for(int i=0; i<matrix.size(); i++){
            int cnt = 0;
            for(int j=0; j<matrix.size(); j++){
                if(i==j) continue;
                bool ok = true;
                for(int k=0; k<matrix[0].size(); k++){
                    if(matrix[i][k] != matrix[j][k] && matrix[i][k] != 1-matrix[j][k]){
                        ok = false;
                        break;
                    }
                }
                if(ok) cnt++;
            }
            res = max(res, cnt);
        }
        return res+1;
    }
};