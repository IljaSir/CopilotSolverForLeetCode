class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        
        int res = 0;
        int n = timeSeries.size();
        for (int i = 0; i < n; i++) {
            int t = timeSeries[i];
            res += duration;
            if (i + 1 < n && t + duration - 1 >= timeSeries[i + 1]) {
                res -= t + duration - 1 - timeSeries[i + 1];
            }
        }
        return res;
    }
};