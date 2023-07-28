class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long long res = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid + 1] - sum[i] >= lower) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int left = l;
            l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid + 1] - sum[i] <= upper) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int right = l;
            res += right - left;
        }
        return res;
    }
};