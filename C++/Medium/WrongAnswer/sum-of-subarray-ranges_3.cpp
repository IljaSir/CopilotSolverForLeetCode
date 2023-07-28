class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, -1), right(n, n);
        stack<int> stk;
        for (int i = 0; i < n; ++i) {
            while (!stk.empty() && nums[stk.top()] >= nums[i]) stk.pop();
            if (!stk.empty()) left[i] = stk.top();
            stk.push(i);
        }
        stk = stack<int>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.empty() && nums[stk.top()] > nums[i]) stk.pop();
            if (!stk.empty()) right[i] = stk.top();
            stk.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (long long)nums[i] * (i - left[i]) * (right[i] - i);
        }
        return ans;
    }
};