class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        if (m*k > bloomDay.size())
            return -1;
        int left = 1, right = 1e9;
        while (left < right) {
            int mid = (left + right) / 2;
            int bouquets = 0, flowers = 0;
            for (int i = 0; i < bloomDay.size() && bouquets < m; ++i) {
                if (bloomDay[i] <= mid) {
                    if (++flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};