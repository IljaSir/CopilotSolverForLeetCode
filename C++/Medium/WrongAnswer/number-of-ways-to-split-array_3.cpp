class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            if (sum[n - 1] - sum[i] < sum[i]) break;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid] - sum[i] >= sum[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int l2 = l;
            l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (sum[n - 1] - sum[mid - 1] >= sum[mid - 1] - sum[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int r2 = l;
            if (l2 <= r2) {
                count = (count + (r2 - l2 + 1)) % 1000000007;
            }
        }
        return count;
    }
};