class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        int m = n / 2;
        int n1 = n - m;
        vector<int> a, b;
        for (int i = 0; i < (1 << m); i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (i & (1 << j)) {
                    sum += nums[j];
                }
            }
            a.push_back(sum);
        }
        for (int i = 0; i < (1 << n1); i++) {
            int sum = 0;
            for (int j = 0; j < n1; j++) {
                if (i & (1 << j)) {
                    sum += nums[j + m];
                }
            }
            b.push_back(sum);
        }
        sort(b.begin(), b.end());
        int res = abs(goal);
        for (auto x : a) {
            int l = 0, r = b.size() - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (b[mid] + x == goal) {
                    return 0;
                } else if (b[mid] + x < goal) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (l < b.size()) {
                res = min(res, abs(goal - (b[l] + x)));
            }
            if (r >= 0) {
                res = min(res, abs(goal - (b[r] + x)));
            }
        }
        return res;
    }
};