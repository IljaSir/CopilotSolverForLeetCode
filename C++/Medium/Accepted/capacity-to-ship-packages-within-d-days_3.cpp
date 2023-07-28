class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        
        int lo = 0, hi = 0;
        for (int w : weights) {
            lo = max(lo, w);
            hi += w;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int need = 1, cur = 0;
            for (int w : weights) {
                if (cur + w > mid) {
                    need++;
                    cur = 0;
                }
                cur += w;
            }
            if (need <= days) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
};