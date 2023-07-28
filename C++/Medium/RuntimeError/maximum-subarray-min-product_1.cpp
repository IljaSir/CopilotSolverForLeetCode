class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        vector<int> stack;
        vector<int> left(n, -1), right(n, n);
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && nums[stack.back()] >= nums[i]) {
                right[stack.back()] = i;
                stack.pop_back();
            }
            if (!stack.empty()) {
                left[i] = stack.back();
            }
            stack.push_back(i);
        }
        int64_t result = 0;
        for (int i = 0; i < n; ++i) {
            int64_t area = sum[right[i]] - sum[left[i] + 1];
            result = max(result, area * nums[i]);
        }
        return result % 1000000007;
    }
};