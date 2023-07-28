class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        sort(timePoints.begin(), timePoints.end());
        int minDiff = 24*60;
        for (int i = 0; i < timePoints.size(); i++) {
            int j = (i + 1) % timePoints.size();
            int diff = timeDiff(timePoints[i], timePoints[j]);
            minDiff = min(minDiff, diff);
        }
        return minDiff;
    }
};