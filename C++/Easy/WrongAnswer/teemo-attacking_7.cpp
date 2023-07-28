class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        
        int n = timeSeries.size();
        if (n == 0) return 0;
        int i = 0, j = 1;
        int ans = 0;
        while (j < n) {
            if (timeSeries[j] - timeSeries[i] < duration) {
                j++;
            } else {
                ans += duration;
                i = j;
                j++;
            }
        }
        ans += duration;
        return ans;
    }
};