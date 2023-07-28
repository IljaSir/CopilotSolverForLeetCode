class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n, n);
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && (nums[stack.back()] | nums[i]) == nums[stack.back()]) {
                stack.pop_back();
            }
            if (!stack.empty()) {
                res[i] = i - stack.back();
            }
            stack.push_back(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.empty() && (nums[stack.back()] | nums[i]) == nums[stack.back()]) {
                stack.pop_back();
            }
            if (!stack.empty()) {
                res[i] = min(res[i], stack.back() - i);
            }
            stack.push_back(i);
        }
        return res;
    }
};