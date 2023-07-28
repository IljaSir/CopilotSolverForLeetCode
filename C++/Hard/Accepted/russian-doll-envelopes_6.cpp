class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        
        std::sort(envelopes.begin(), envelopes.end(), [](const auto& a, const auto& b) {
            return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
        });
        std::vector<int> dp;
        for (const auto& e : envelopes) {
            auto it = std::lower_bound(dp.begin(), dp.end(), e[1]);
            if (it == dp.end()) {
                dp.push_back(e[1]);
            } else {
                *it = e[1];
            }
        }
        return dp.size();
    }
};