class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<int> maxCharge(n, 0);
        for (int i = 0; i < n; ++i) {
            maxCharge[i] = chargeTimes[i];
            if (i > 0) {
                maxCharge[i] = max(maxCharge[i], maxCharge[i-1]);
            }
        }
        vector<int> sum(n, 0);
        for (int i = 0; i < n; ++i) {
            sum[i] = runningCosts[i];
            if (i > 0) {
                sum[i] += sum[i-1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            long long cost = maxCharge[i] + sum[i];
            if (cost > budget) {
                break;
            }
            int l = i, r = n - 1, m;
            while (l < r) {
                m = (l + r + 1) / 2;
                cost = maxCharge[i] + (sum[m] - sum[i]);
                if (cost <= budget) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            ans = max(ans, l - i + 1);
        }
        return ans;
    }
};