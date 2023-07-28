class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        
        int res = 0, mx = values[0] + 0;
        for (int j = 1; j < values.size(); ++j) {
            res = max(res, mx + values[j] - j);
            mx = max(mx, values[j] + j);
        }
        return res;
    }
};