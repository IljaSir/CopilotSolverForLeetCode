class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        vector<int> min(n, 0);
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = min(min[i-1], nums[i]);
        }
        stack<int> stk;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!stk.empty() && stk.top() <= min[i]) {
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