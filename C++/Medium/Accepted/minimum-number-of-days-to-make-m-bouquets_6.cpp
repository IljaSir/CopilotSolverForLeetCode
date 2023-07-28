class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        int n = bloomDay.size();
        if ((long long)m * k > n) return -1;
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(bloomDay, m, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    bool check(vector<int>& bloomDay, int m, int k, int day) {
        int cnt = 0;
        for (int i = 0; i < bloomDay.size(); ++i) {
            if (bloomDay[i] <= day) {
                ++cnt;
                if (cnt == k) {
                    --m;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return m <= 0;
    }
};