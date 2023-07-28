class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        sort(timePoints.begin(), timePoints.end());
        int n = timePoints.size();
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int t1 = stoi(timePoints[i].substr(0, 2)) * 60 + stoi(timePoints[i].substr(3));
            int t2 = stoi(timePoints[(i + 1) % n].substr(0, 2)) * 60 + stoi(timePoints[(i + 1) % n].substr(3));
            ans = min(ans, (t2 - t1 + 1440) % 1440);
        }
        return ans;
    }
};