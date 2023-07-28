class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        int target = sum - x;
        if (target == 0) return n;
        int left = 0, right = 0, curr = 0, ans = -1;
        while (right < n) {
            curr += nums[right++];
            while (curr > target && left < right) {
                curr -= nums[left++];
            }
            if (curr == target) {
                if (ans == -1) {
                    ans = n - (right - left);
                } else {
                    ans = min(ans, n - (right - left));
                }
            }
        }
        return ans;
    }
};