class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        
        vector<int> time;
        for (auto &s : timePoints) {
            int h = stoi(s.substr(0, 2));
            int m = stoi(s.substr(3, 2));
            time.push_back(h * 60 + m);
        }
        sort(time.begin(), time.end());
        int n = time.size();
        int ans = 24 * 60 - time[n - 1] + time[0];
        for (int i = 1; i < n; i++) {
            ans = min(ans, time[i] - time[i - 1]);
        }
        return ans;
    }
};