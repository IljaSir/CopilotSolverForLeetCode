class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        vector<int> time;
        for (auto& t : timePoints) {
            int h = stoi(t.substr(0, 2));
            int m = stoi(t.substr(3));
            time.push_back(h * 60 + m);
        }
        sort(time.begin(), time.end());
        int res = INT_MAX;
        for (int i = 1; i < time.size(); ++i) {
            res = min(res, time[i] - time[i - 1]);
        }
        res = min(res, time[0] + 1440 - time.back());
        return res;
    }
};