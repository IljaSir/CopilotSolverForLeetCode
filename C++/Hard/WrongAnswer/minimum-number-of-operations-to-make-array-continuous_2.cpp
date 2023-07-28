class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int i = 0, j = 0, res = n;
        while (j < n) {
            if (nums[j] - nums[i] < n) {
                res = min(res, j - i + 1);
                ++j;
            } else {
                ++i;
            }
        }
        return n - res;
    }
};