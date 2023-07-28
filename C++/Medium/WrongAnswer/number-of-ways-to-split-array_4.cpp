class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n + 1);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid] - sum[i + 1] >= sum[i + 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int l1 = l;
            l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[n] - sum[mid] >= sum[mid] - sum[i + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int r1 = l - 1;
            if (l1 <= r1) {
                ans = (ans + r1 - l1 + 1) % 1000000007;
            }
        }
        return ans;
    }
};