class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        
        int n = values.size();
        int mx = values[0] + 0;
        int res = 0;
        for (int j = 1; j < n; ++j) {
            res = max(res, mx + values[j] - j);
            mx = max(mx, values[j] + j);
        }
        return res;
    }
};