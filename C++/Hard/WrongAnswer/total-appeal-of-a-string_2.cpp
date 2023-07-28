class Solution {
public:
    long long appealSum(string s) {
        
        int n = s.length();
        vector<vector<int>> dp(n,vector<int>(26,0));
        for(int i=0;i<n;i++){
            dp[i][s[i]-'a']++;
            if(i>0){
                for(int j=0;j<26;j++){
                    dp[i][j]+=dp[i-1][j];
                }
            }
        }
        long long ans = 0;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<26;j++){
                if(dp[i][j]>0){
                    cnt++;
                }
            }
            ans+=cnt*(i+1);
        }
        return ans;
    }
};