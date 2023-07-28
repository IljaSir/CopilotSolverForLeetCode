class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        
        sort(envelopes.begin(), envelopes.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
        });
        vector<int> dp;
        for (const auto& e : envelopes) {
            auto it = lower_bound(dp.begin(), dp.end(), e[1]);
            if (it == dp.end()) {
                dp.push_back(e[1]);
            } else {
                *it = e[1];
            }
        }
        return dp.size();
    }
};