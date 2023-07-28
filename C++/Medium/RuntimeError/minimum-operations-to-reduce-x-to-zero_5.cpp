class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int target = sum - x;
        if (target == 0) return n;
        int i = 0, j = 0, cur = 0, res = -1;
        while (j < n) {
            cur += nums[j];
            while (cur > target) {
                cur -= nums[i];
                i++;
            }
            if (cur == target) {
                res = max(res, j - i + 1);
            }
            j++;
        }
        return res == -1 ? -1 : n - res;
    }
};