class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int target = sum - x;
        if (target == 0) return n;
        if (target < 0) return -1;
        int left = 0, right = 0, sum1 = 0, res = -1;
        while (right < n) {
            sum1 += nums[right];
            while (sum1 > target && left <= right) {
                sum1 -= nums[left];
                left++;
            }
            if (sum1 == target) {
                res = max(res, right - left + 1);
            }
            right++;
        }
        if (res == -1) return -1;
        return n - res;
    }
};