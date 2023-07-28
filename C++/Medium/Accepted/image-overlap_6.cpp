class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n = img1.size();
        vector<vector<int>> v(2*n+1,vector<int>(2*n+1,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1){
                    for(int k=0;k<n;k++){
                        for(int l=0;l<n;l++){
                            if(img2[k][l]==1){
                                v[i-k+n][j-l+n]++;
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0;i<2*n+1;i++){
            for(int j=0;j<2*n+1;j++){
                ans = max(ans,v[i][j]);
            }
        }
        return ans;
    }
};