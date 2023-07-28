class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int m=points.size(), n=points[0].size();
        vector<long long> dp(n, 0);
        for (int i=0; i<m; ++i) {
            vector<long long> ndp(n, 0);
            vector<long long> pre(n, 0), suf(n, 0);
            pre[0]=dp[0];
            for (int j=1; j<n; ++j) {
                pre[j]=max(pre[j-1], dp[j]+j);
            }
            suf[n-1]=dp[n-1]-n+1;
            for (int j=n-2; j>=0; --j) {
                suf[j]=max(suf[j+1], dp[j]-j);
            }
            for (int j=0; j<n; ++j) {
                ndp[j]=points[i][j]+max(pre[j]-j, suf[j]+j);
            }
            dp=ndp;
        }
        return *max_element(dp.begin(), dp.end());
    }
};