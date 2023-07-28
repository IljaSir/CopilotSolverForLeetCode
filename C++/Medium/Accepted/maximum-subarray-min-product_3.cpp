class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        int n = nums.size();
        vector<long long> pre(n + 1);
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        vector<int> stack;
        vector<int> left(n);
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && nums[stack.back()] >= nums[i]) {
                stack.pop_back();
            }
            left[i] = stack.empty() ? -1 : stack.back();
            stack.push_back(i);
        }
        stack.clear();
        vector<int> right(n);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.back()] >= nums[i]) {
                stack.pop_back();
            }
            right[i] = stack.empty() ? n : stack.back();
            stack.push_back(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, nums[i] * (pre[right[i]] - pre[left[i] + 1]));
        }
        return ans % (int)(1e9 + 7);
    }
};