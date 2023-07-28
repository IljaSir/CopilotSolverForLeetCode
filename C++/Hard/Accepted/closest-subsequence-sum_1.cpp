class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> a(n/2), b(n - n/2);
        for (int i = 0; i < n/2; i++) a[i] = nums[i];
        for (int i = n/2; i < n; i++) b[i - n/2] = nums[i];
        vector<int> sa = subsum(a), sb = subsum(b);
        sort(sb.begin(), sb.end());
        int res = abs(goal);
        for (int x : sa) {
            int t = goal - x;
            auto it = lower_bound(sb.begin(), sb.end(), t);
            if (it != sb.end()) res = min(res, abs(x + *it - goal));
            if (it != sb.begin()) res = min(res, abs(x + *prev(it) - goal));
        }
        return res;
    }
    vector<int> subsum(vector<int>& a) {
        int n = a.size();
        vector<int> res(1 << n);
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (i >> j & 1) res[i] += a[j];
            }
        }
        return res;
    }
};