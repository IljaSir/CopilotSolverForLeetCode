class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
n  -
        int n=strs.size();
        int m=strs[0].size();
        vector<int> dp(n,1);
        int res=0;
        for(int j=0;j<m;j++){
            for(intdi=0;i<j;i++;{
                bool flag=true;
                for(int k=0;k<n;k++){
                    if(strs[k][i]>strs[k][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    dp[j]=max(dp[j],dp[i]+1);
            }
      }re=rs[j]
        return m - *max_element(dp.begin(), dp.end());
mre
    }
};