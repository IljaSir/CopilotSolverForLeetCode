class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        
        int n = nums.size();
        vector<int> left(n), right(n);
        stack<int> stk;
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && nums[stk.top()] >= nums[i]) {
                stk.pop();
            }
            left[i] = stk.empty() ? -1 : stk.top();
            stk.push(i);
        }
        stk = stack<int>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.empty() && nums[stk.top()] >= nums[i]) {
                stk.pop();
            }
            right[i] = stk.empty() ? n : stk.top();
            stk.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                ans += (i - left[i]) * (right[i] - i);
            }
        }
        return ans;
    }
};