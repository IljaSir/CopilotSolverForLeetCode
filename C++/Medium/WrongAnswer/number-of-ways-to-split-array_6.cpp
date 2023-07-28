class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> pre(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (pre[mid] - pre[i] < pre[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (pre[l] - pre[i] < pre[i]) {
                continue;
            }
            int j = l;
            l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (pre[n] - pre[mid] < pre[mid] - pre[i]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (pre[n] - pre[l] < pre[l] - pre[i]) {
                continue;
            }
            int k = l;
            ans = (ans + k - j + 1) % 1000000007;
        }
        return ans;
    }
};