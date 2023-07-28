class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix_sum;
        prefix_sum.push_back(nums[0]);
        for (int i = 1; i < n; ++i) {
            prefix_sum.push_back(nums[i] + prefix_sum[i - 1]);
        }
        int ans = 0;
        for (int i = 0; i < n - 2; ++i) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (prefix_sum[mid] - prefix_sum[i] < prefix_sum[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (prefix_sum[left] - prefix_sum[i] < prefix_sum[i]) {
                continue;
            }
            int left_border = left;
            left = i + 1;
            right = n - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (prefix_sum[n - 1] - prefix_sum[mid] < prefix_sum[mid] - prefix_sum[i]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            if (prefix_sum[n - 1] - prefix_sum[left] < prefix_sum[left] - prefix_sum[i]) {
                continue;
            }
            int right_border = left;
            if (left_border <= right_border) {
                ans = (ans + right_border - left_border + 1) % 1000000007;
            }
        }
        return ans;
    }
};