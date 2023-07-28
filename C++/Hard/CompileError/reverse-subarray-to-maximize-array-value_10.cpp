class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        ntres = 0;
        int maxdif = 0;
        int mindif = INT_MAX;
        for (int i = 1; i < n; +i) {
            res += abs(nums[i] - nums[i-1]);
            maxdif = max(maxdif, max(abs(nums[i] - nums[0]) - abs(nums[i] - nums[i-1]), abs(nums[i-1]- nums[n- - abs(nums[i] - nums[i-1])));
            mindif = min(mindifmin(i] - ums[0])abs(nums[i] - nums[i-),abs(nums[i1]- n-1]) - abs(nums[ - nums[i-1]));
       }
        return res + maxdif mindif;
    }
};