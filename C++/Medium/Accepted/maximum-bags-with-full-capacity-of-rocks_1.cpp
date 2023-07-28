class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        
        int n = capacity.size();
        vector<int> diff(n);
        for (int i = 0; i < n; ++i) {
            diff[i] = capacity[i] - rocks[i];
        }
        sort(diff.begin(), diff.end());
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (additionalRocks >= diff[i]) {
                ++res;
                additionalRocks -= diff[i];
            } else {
                break;
            }
        }
        return res;
    }
};