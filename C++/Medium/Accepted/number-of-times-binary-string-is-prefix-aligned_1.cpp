class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        
        int n = flips.size();
        int res = 0;
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            mx = max(mx, flips[i]);
            if (mx == i + 1) {
                ++res;
            }
        }
        return res;
    }
};