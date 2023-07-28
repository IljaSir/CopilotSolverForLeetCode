class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        int n = bloomDay.size();
        if (m * k > n) return -1;
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    bool canMake(vector<int>& bloomDay, int m, int k, int day) {
        int n = bloomDay.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (bloomDay[i] <= day) {
                ++cnt;
                if (cnt == k) {
                    cnt = 0;
                    --m;
                    if (m == 0) return true;
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }
};