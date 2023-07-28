class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, n);
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && nums[stack.back()] < nums[i]) {
                ans[stack.back()] = i - stack.back();
                stack.pop_back();
            }
            stack.push_back(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int p) {
        int n = nums.size();
        vector<int> ans(n, n);
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && nums[stack.back()] > nums[i]) {
                ans[stack.back()] = i - stack.back();
                stack.pop_back();
            }
            stack.push_back(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int p, int q) {
        int n = nums.size();
        vector<int> ans(n, n);
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && nums[stack.back()] > nums[i]) {
                ans[stack.back()] = i - stack.back();
                stack.pop_back();
            }
            stack.push_back(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.back()] >= nums[i]) {
                ans[stack.back()] = min(ans[stack.back()], stack.back() - i);
                stack.pop_back();
            }
            stack.push_back(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int p, int q, int r) {
        int n = nums.size();
        vector<int> ans(n, n);
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            while (!stack.empty() && nums[stack.back()] > nums[i]) {
                ans[stack.back()] = i - stack.back();
                stack.pop_back();
            }
            stack.push_back(i);
        }
        stack.clear();
        for (int i = n - 1; i >=
    }
};