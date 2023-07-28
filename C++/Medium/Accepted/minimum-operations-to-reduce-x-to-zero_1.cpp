class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int target = sum - x;
        if (target < 0) return -1;
        if (target == 0) return n;
        int ans = INT_MAX;
        int l = 0;
        int r = 0;
        int cur = 0;
        while (r < n) {
            cur += nums[r];
            while (cur > target) {
                cur -= nums[l];
                l++;
            }
            if (cur == target) {
                ans = min(ans, n - (r - l + 1));
            }
            r++;
        }
        return ans == INT_MAX ? -1 : ans;
    }
};