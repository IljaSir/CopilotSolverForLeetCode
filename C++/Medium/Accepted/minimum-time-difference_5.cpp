class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        vector<int> minutes;
        for (string& timePoint: timePoints) {
            minutes.push_back(60 * stoi(timePoint.substr(0, 2)) + stoi(timePoint.substr(3, 2)));
        }
        sort(minutes.begin(), minutes.end());
        int minDiff = 24 * 60 + minutes[0] - minutes.back();
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = min(minDiff, minutes[i] - minutes[i - 1]);
        }
        return minDiff;
    }
};