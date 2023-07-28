class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n, n);
        vector<int> stk;
        for (int i = 0; i < n; ++i) {
            while (!stk.empty() && (nums[stk.back()] | nums[i]) == nums[stk.back()]) {
                res[stk.back()] = i - stk.back();
                stk.pop_back();
            }
            stk.push_back(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.empty() && (nums[stk.back()] | nums[i]) == nums[stk.back()]) {
                res[stk.back()] = min(res[stk.back()], stk.back() - i);
                stk.pop_back();
            }
            stk.push_back(i);
        }
        return res;
    }
};