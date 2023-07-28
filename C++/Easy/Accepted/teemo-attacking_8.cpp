class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        
        int n = timeSeries.size();
        if (n == 0) return 0;
        int total = duration;
        int last = timeSeries[0];
        for (int i = 1; i < n; ++i) {
            if (timeSeries[i] - last < duration) {
                total += timeSeries[i] - last;
            } else {
                total += duration;
            }
            last = timeSeries[i];
        }
        return total;
    }
};