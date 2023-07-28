class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        
        int l = *max_element(weights.begin(), weights.end());
        int r = accumulate(weights.begin(), weights.end(), 0) + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int need = 1;
            int cur = 0;
            for (int i = 0; i < weights.size() && need <= days; ++i) {
                if (cur + weights[i] > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weights[i];
            }
            if (need > days) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};