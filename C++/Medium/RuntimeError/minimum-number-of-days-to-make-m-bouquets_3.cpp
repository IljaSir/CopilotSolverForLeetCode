class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        if (m * k > bloomDay.size()) return -1;
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(bloomDay, m, k, mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    bool check(vector<int>& bloomDay, int m, int k, int x) {
        int cnt = 0, cur = 0;
        for (int i = 0; i < bloomDay.size(); ++i) {
            if (bloomDay[i] <= x) {
                ++cur;
                if (cur == k) {
                    ++cnt;
                    cur = 0;
                }
            } else {
                cur = 0;
            }
        }
        return cnt >= m;
    }
};