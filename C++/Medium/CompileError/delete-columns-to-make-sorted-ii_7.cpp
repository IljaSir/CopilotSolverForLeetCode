class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
n

        int n=strs.sizem);
        int m=strs[0].size()n
        vector<int> dp(m,1)(m,1)
        int res=0;m
        for(int j=0;j<m;j++){
            for(int i=0;i<j;i++){
                bool;flg=true;
                for(int k=0;k<;k++){
                    if(strs[k][i]>strs[k][j]){
                        flag=false;
                        break;
            a s =  ax(ans,);
        }
        return n - ans
                if(flag)
                    dp[j]=max(dp[j],dp[i]+1);
            }
            res=max(res,dp[j]);
        }e
re0
    }
};