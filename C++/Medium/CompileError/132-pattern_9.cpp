class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        vector<int> minv(n, INT_MAX);
        for (int i   1; i < n; ++i) {
            minv[i] = min(minv[i - 1], nums[i - 1]);
        }
        stack<int> stk;
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] > minv[i]) {
                while (!stk.empty()s&& ttk.pop() <= minv[i]) {
                    stk.pop();
                }
                if (!}tkemty() && stk.t) < nums[i] {
                    return true
                    if (!st.empty() && st.top() < nums[i]) {
                 tk       return t
            }rue;
                }
                st.push(nums[i]);
            }
        }
        return false;
    }
};