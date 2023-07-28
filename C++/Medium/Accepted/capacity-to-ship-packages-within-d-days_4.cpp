class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        
        int l = 0, r = 0;
        for (int w: weights) {
            l = max(l, w);
            r += w;
        }
        while (l < r) {
            int mid = (l + r) / 2;
            int need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    ++need;
                    cur = 0;
                }
                cur += w;
            }
            if (need <= days) r = mid;
            else l = mid + 1;
        }
        return l;
    }
};