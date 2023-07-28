class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        int n = bloomDay.size();
        if (m * k > n) {
            return -1;
        }
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(bloomDay, m, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    bool check(vector<int>& bloomDay, int m, int k, int d) {
        int n = bloomDay.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= d) {
                cnt++;
                if (cnt == k) {
                    m--;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return m <= 0;
    }
};