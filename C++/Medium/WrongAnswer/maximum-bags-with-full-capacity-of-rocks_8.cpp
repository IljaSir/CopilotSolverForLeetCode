class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        
        int n = capacity.size();
        int l = 0, r = 1e9;
        while (l < r) {
            int m = (l + r + 1) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                cnt += max(0, capacity[i] - rocks[i]) / m;
            }
            if (cnt <= additionalRocks) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }
};