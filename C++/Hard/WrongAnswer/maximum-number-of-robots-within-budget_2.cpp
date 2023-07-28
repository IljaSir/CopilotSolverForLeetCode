class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < n; i++) {
            v.push_back(make_pair(chargeTimes[i], runningCosts[i]));
        }
        sort(v.begin(), v.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long long cost = 0;
            int j = i;
            while (j < n && cost + (long long)v[j].first + (long long)(j - i) * (long long)v[j].second <= budget) {
                cost += (long long)v[j].first + (long long)(j - i) * (long long)v[j].second;
                j++;
            }
            ans = max(ans, j - i);
        }
        return ans;
    }
};