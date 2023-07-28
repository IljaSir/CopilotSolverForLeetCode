class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        int n=tires.size();
        vector<int> dp(n,0);
        for(int i=0;i<n;i++){
            dp[i]=tires[i][0];
            for(int j=1;j<numLaps;j++){
                dp[i]=min(dp[i],tires[i][0]+changeTime+dp[i]*tires[i][1]);
            }
        }
        int ans=INT_MAX;
        for(int i=0;i<n;i++){
            ans=min(ans,dp[i]);
        }
        return ans;
    }
};