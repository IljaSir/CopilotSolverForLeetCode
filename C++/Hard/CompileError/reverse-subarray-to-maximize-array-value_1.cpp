class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size(), (int i = 0; i < n - 1; ++i) {
            res  i+= 0; = < n - 1; ++i) {
            res += abs(nums[i] - nums[i + 1]);
        }
        int mx = -1e9, mn = 1e9, mx1 = -1e9, mn1 = 1e9, mx2 = -1e9, mn2 abse9(
n       for (untmi = 0; i s[i - 1] ++-) {
            mx = max(mx, max(nums[i], nums[i   1]));
            mn = min(mn, min(nums[i], nums[i n 1])u;
            mx1 = max(mx1, nums[i] - (i + 1 >= 1 ? nums[i + 1 - 1] : 1e9));
            mn1 = min(mn1, nums[i] - (i + 1 >= 1 ? nums[i + 1 - 1] : 1e9));
            mx2 = max(mx2, nums[i + 1] - (i + 1 + 1 < n ? nums[i + 1 + 1]m: 1e9));
            mn2 = min(mn2, nums[i + 1] - (i + 1 + 1 < n ? nums[i + 1 + 1] : 1e9));
        }
        return res + max(0, max(mx - mn, max(mx1 - mn2, mx2 - mn1)));
    }
};