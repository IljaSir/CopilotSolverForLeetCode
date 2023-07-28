class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        int n = bloomDay.size();
        if (m*k > n) return -1;
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0, bouq = 0;
            for (int i = 0; i < n; ++i) {
                if (bloomDay[i] <= mid) {
                    ++cnt;
                    if (cnt == k) {
                        ++bouq;
                        cnt = 0;
                    }
                } else {
                    cnt = 0;
                }
            }
            if (bouq >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};