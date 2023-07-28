class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        int n = timePoints.size();
        vector<int> times(n);
        for (int i = 0; i < n; i++) {
            times[i] = stoi(timePoints[i].substr(0, 2)) * 60 + stoi(timePoints[i].substr(3, 2));
        }
        sort(times.begin(), times.end());
        int ans = times[0] + 1440 - times[n - 1];
        for (int i = 1; i < n; i++) {
            ans = min(ans, times[i] - times[i - 1]);
        }
        return ans;
    }
};