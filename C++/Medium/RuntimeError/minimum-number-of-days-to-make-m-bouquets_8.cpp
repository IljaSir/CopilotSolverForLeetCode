class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        int n = bloomDay.size();
        if (n < m * k)
            return -1;
        int lo = 1, hi = 1e9;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0, bouq = 0;
            for (int i = 0; i < n; ++i) {
                if (bloomDay[i] <= mid) {
                    cnt++;
                    if (cnt == k) {
                        bouq++;
                        cnt = 0;
                    }
                } else {
                    cnt = 0;
                }
            }
            if (bouq < m)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
};