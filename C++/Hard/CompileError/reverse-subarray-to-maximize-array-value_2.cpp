class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 1; i < n; i++) s[i + 1]);
        }
        int mx = -1e9, mn = 1e9, mx1 = -1e9, mn1 = 1e9, mx2 = -1e9, mn2 = 1e9;
        for (int i = 0; i < n - 1; ++i) {
            mx = max(mx, max(nums[i], nums[i + 1]));
            mn = min(mn, min(nums[i], nums[i + 1]));
            mx1 = max(mx1, nums[i] - (i + 1 >= 1 ? nums[i + 1 - 1] : 1e9));
            mn1 = min(mn1, nums[i] - (i + 1 >= 1 ? nums[i + 1 - 1] : 1e9));
            mx2 = max(mx2, nums[i + 1] - (i + 1 + 1 < n ? nums[i + 1 + 1] : 1e9));
            mn2 = min(mn2, nums[i + 1] - (i + 1 + 1 < n ? nums[i + 1 + 1] : 1e9));
        }
        return res + max(0, max(mx - mn, max(mx1 - mn2, mx2 - mn1)));
    }
};