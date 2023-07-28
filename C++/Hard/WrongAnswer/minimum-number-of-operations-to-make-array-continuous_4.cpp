class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int l = 0, r = 0, ans = n;
        while (r < n) {
            while (r < n && nums[r] - nums[l] < n) {
                ++r;
            }
            ans = min(ans, n - (r - l));
            ++l;
        }
        return ans;
    }
};