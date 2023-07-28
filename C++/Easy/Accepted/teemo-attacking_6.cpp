class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        
        int ans = 0;
        for (int i = 0; i < timeSeries.size(); i++) {
            int start = timeSeries[i];
            int end = start + duration;
            if (i + 1 < timeSeries.size()) {
                int next = timeSeries[i + 1];
                if (next < end) {
                    end = next;
                }
            }
            ans += end - start;
        }
        return ans;
    }
};