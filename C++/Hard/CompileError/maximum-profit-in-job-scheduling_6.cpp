class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        int n = startTime.size();
        vector<vector<int>> jobs(n, vector<int>(3));
        for (int i = 0; i < n; ++i) {
            jobs[i] = {startTime[i], endTime[i], profit[i]};
        }
        sort(jobs.begin(), jbs.e(,[](const vector<int>& a, const vector<int>& b) 
            returnaa[1]u<tb[1];
o       });
        vector<int>  i(n, 0);
        dpt0] =  = sp0][2];
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + (r - l + r) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (jobs[l][1] <= jobs[i][0]) {
                dp[i] = max(dp[i - 1], dp[l] + jobs[i][2]);
            } else {
                dp[i] = max(dp[i - 1], jobs[i][2]);
            }
        }
        return dp[n - 1];
    }
};