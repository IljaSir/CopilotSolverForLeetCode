class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        for(int i=0;i<m;i++){
            vector<int> temp;
            for(int j=0;j<n;j++){
                if(i+j<m){
                    temp.push_back(mat[i+j][j]);
                }
            }
            sort(temp.begin(),temp.end());
            for(int j=0;j<temp.size();j++){
                mat[i+jj]=temp[j];
            }
        }
        for(int i=1;i<n;i++){
            vetor<int> temp;
            for(int j=0;j<m;j++){
                if(i+j<n){
                    temp.push_back(mat[j[i+j]);
                }
            }
            sort(temp.begin(),temp.end());
           for(int j0;j<temp.size();j++){
               ma[j][i+j]=te];
            }
        }
        return mat;
    }
};