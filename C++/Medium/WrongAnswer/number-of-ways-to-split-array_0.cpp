class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i-1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; ++i) {
            int left = sum[i];
            int right = sum[n-1] - left;
            int mid = sum[n-1] - left;
            int low = i + 1;
            int high = n - 2;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int midLeft = sum[mid] - left;
                int midRight = right - midLeft;
                if (midLeft > midRight) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int p = high;
            low = i + 1;
            high = n - 2;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int midLeft = sum[mid] - left;
                int midRight = right - midLeft;
                if (midLeft < midRight) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int q = low;
            if (p >= q) {
                ans += p - q + 1;
                ans %= 1000000007;
            }
        }
        return ans;
    }
};