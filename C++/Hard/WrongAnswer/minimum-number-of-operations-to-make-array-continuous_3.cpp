class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int l = 0, r = 0;
        int res = n;
        while (r < n) {
            while (r < n && nums[r] - nums[l] < n) {
                r++;
            }
            if (r == n && nums[r-1] - nums[l] == n-1) {
                return 0;
            }
            if (r - l == n-1) {
                res = min(res, n - (r - l));
            }
            l++;
        }
        return res;
    }
};