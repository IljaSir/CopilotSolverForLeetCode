class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        
        int n = timeSeries.size();
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            if (timeSeries[i] - timeSeries[i - 1] >= duration) {
                ans += duration;
            } else {
                ans += timeSeries[i] - timeSeries[i - 1];
            }
        }
        return ans + duration;
    }
};