class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int max1 = INT_MIN, max2 = INT_MIN, min1 = INT_MAX, min2 = INT_MAX;
        for (int i = 0; i < n - 1; ++i) {
            ans += abs(nums[i] - nums[i + 1]);
            max1 = max(max1, max(nums[i], nums[i + 1]));
            min1 = min(min1, min(nums[i], nums[i + 1]));
            max2 = max(max2, min(nums[i], nums[i + 1]));
            min2 = min(min2, max(nums[i], nums[i + 1]));
        }nums[i] -  + 1]), abs(nums[n - 1i]) - abs(nums[i] - nums[i + 1])));
        }
        return sum + max(0, maxdiff - mindiff);
    }
};