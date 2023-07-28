class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> stk;
        for (int i = 0; i < n; i++) {
            if (stk.empty() || nums[stk.back()] > nums[i]) {
                stk.push_back(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.empty() && nums[stk.back()] <= nums[i]) {
                ans = max(ans, i - stk.back());
                stk.pop_back();
            }
        }
        return ans;
    }
};