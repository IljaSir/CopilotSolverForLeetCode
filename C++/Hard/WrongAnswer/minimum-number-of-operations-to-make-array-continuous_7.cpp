class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans = n - 1;
        int i = 1;
        int j = 0;
        while (i < n) {
            while (i < n && nums[i] == nums[i - 1]) {
                ++i;
            }
            while (j < n && nums[i] - nums[j] >= n) {
                ++j;
            }
            ans = min(ans, n - (i - j));
            ++i;
        }
        return ans;
    }
};