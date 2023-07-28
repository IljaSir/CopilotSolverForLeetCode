class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        vector<int> pre(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        long long res = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (pre[mid] - pre[i] >= lower) r = mid - 1;
                else l = mid;
            }
            int left = l;
            l = i + 1, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (pre[mid] - pre[i] <= upper) l = mid + 1;
                else r = mid;
            }
            int right = l;
            res += right - left;
        }
        return res;
    }
};