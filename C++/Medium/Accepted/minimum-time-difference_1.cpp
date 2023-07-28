class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        vector<int> minutes;
        for (auto &timePoint: timePoints) {
            minutes.push_back(stoi(timePoint.substr(0, 2)) * 60 + stoi(timePoint.substr(3, 2)));
        }
        sort(minutes.begin(), minutes.end());
        int minDiff = INT_MAX;
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = min(minDiff, minutes[i] - minutes[i - 1]);
        }
        minDiff = min(minDiff, 1440 - minutes[minutes.size() - 1] + minutes[0]);
        return minDiff;
    }
};