class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            if (stack.empty() || nums[stack.back()] > nums[i]) {
                stack.push_back(i);
            }
        }
        int res = 0;
        for (int i = n - 1; i >= res; --i) {
            while (!stack.empty() && nums[stack.back()] <= nums[i]) {
                res = max(res, i - stack.back());
                stack.pop_back();
            }
        }
        return res;
    }
};