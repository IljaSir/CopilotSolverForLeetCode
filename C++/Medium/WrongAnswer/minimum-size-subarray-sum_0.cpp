class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int ans = INT_MAX;
        for (int i = 1; i <= n; i++) {
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r >> 1;
                if (prefix[i] - prefix[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (prefix[i] - prefix[l] >= target) {
                ans = min(ans, i - l);
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};