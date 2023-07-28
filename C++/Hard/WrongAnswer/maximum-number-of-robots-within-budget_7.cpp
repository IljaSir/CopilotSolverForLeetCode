class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        long long sum = 0;
        for (int i = 0; i < n; i++) sum += runningCosts[i];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (chargeTimes[i] > budget) continue;
            int cnt = 1;
            long long cost = chargeTimes[i];
            for (int j = i + 1; j < n; j++) {
                if (cost + sum > budget) break;
                cost += runningCosts[j];
                cnt++;
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};