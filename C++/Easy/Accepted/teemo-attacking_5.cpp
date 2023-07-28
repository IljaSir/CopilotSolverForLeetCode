class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        
        int N = timeSeries.size();
        if (N == 0) return 0;
        int ans = duration;
        for (int i = 1; i < N; ++i) {
            ans += min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return ans;
    }
};