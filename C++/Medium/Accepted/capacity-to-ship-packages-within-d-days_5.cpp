class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        
        int l = 0, r = 0;
        for (int w : weights) {
            r += w;
            l = max(l, w);
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            int d = 1, s = 0;
            for (int w : weights) {
                if (s + w > m) {
                    d++;
                    s = 0;
                }
                s += w;
            }
            if (d > days) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
};