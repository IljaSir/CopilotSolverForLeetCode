class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, n);
        stack<int> stk;
        for (int i = 0; i < n; ++i) {
            while (!stk.empty() && nums[i] >= nums[stk.top()]) {
                ans[stk.top()] = i - stk.top();
                stk.pop();
            }
            stk.push(i);
        }
        return ans;
    }
    vector<int> maxBitwiseORs(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, 0);
        vector<int> s1 = smallestSubarrays(nums);
        reverse(nums.begin(), nums.end());
        vector<int> s2 = smallestSubarrays(nums);
        reverse(s2.begin(), s2.end());
        for (int i = 0; i < n; ++i) {
            ans[i] = max(ans[i], nums[i]);
            if (i + s1[i] < n) ans[i] = max(ans[i], ans[i + s1[i]] | nums[i]);
            if (i - s2[i] >= 0) ans[i] = max(ans[i], ans[i - s2[i]] | nums[i]);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, vector<int>& maxBitwiseORs) {
        int n = nums.size();
        vector<int> ans(n, n);
        stack<int> stk;
        for (int i = 0; i < n; ++i) {
            while (!stk.empty() && maxBitwiseORs[i] >= maxBitwiseORs[stk.top()]) {
                ans[stk.top()] = i - stk.top();
                stk.pop();
            }
            stk.push(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int k) {
        vector<int> maxBitwiseORs = maxBitwiseORs(nums);
        vector<int> ans = minSubarray(nums, maxBitwiseORs);
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j + ans[j] < n) ans[j] = min(ans[j], ans[j + ans[j]]);
            }
            for (int j = n -
    }
};