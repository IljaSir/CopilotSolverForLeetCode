class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        vector<int> minv(n, INT_MAX);
        for (int i = 1; i < n; ++i) {
            minv[i] = min(minv[i - 1], nums[i - 1]);
        }
        stack<int> stk;
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] > minv[i]) {
                while (!stk.empty() && stk.top() <= minv[i]) {
                    stk.pop();
                }
                if (!stk.empty() && stk.top() < nums[i]) {
                    return true;
                }
                stk.push(nums[i]);
            }
        }
        return false;
    }
};