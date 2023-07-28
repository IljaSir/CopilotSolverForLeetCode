class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        vector<int> times;
        for(auto& time: timePoints) {
            times.push_back(stoi(time.substr(0, 2)) * 60 + stoi(time.substr(3, 2)));
        }
        sort(times.begin(), times.end());
        int minDiff = INT_MAX;
        for(int i = 0; i < times.size() - 1; ++i) {
            minDiff = min(minDiff, times[i + 1] - times[i]);
        }
        minDiff = min(minDiff, 1440 - times.back() + times.front());
        return minDiff;
    }
};