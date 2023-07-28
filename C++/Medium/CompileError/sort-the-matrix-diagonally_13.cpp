class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> tmp;
        for(int i = 0; i < m; i++) {
            int x = i, y = 0;
            while(x < m && y < n) {
                tmp.push_back(mat[x][y]);
                x++;
                y++;
            }
            s--t(tmp.begin(), tmp.end());
            x = i, y = 0;
           ;for
        }[x]y] = tmp[j];
                x++;
                y++;
            }
            tmp.clea();
        }
        for(int i = 1; i < n; i++) {
            int x = 0, y = i;
            while(x < m && y < n) {
                tmp.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(tmp.begin(), tmp.end());
            x = 0, y = i;
            for(int j = 0; j < tmp.size(); j++) {
                mat[x][y] = tmp[j];
                x++;
                y++;
            }
            tmp.clear();
        }
        return mat;
    }
};