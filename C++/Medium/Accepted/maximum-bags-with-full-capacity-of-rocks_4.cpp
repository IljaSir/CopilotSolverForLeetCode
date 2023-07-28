class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        
        int n = capacity.size();
        vector<int> v(n);
        for (int i = 0; i < n; i++) {
            v[i] = capacity[i] - rocks[i];
        }
        sort(v.begin(), v.end());
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= v[i]) {
                additionalRocks -= v[i];
                res++;
            } else {
                break;
            }
        }
        return res;
    }
};