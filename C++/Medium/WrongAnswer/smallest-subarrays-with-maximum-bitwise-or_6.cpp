class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n);
        vector<int> stk;
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && (nums[i] | nums[stk.back()]) == nums[stk.back()]) {
                stk.pop_back();
            }
            res[i] = stk.empty() ? i + 1 : i - stk.back();
            stk.push_back(i);
        }
        return res;
    }
    vector<int> smallestSubarrays2(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n);
        vector<int> stk;
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && (nums[i] | nums[stk.back()]) == nums[stk.back()]) {
                stk.pop_back();
            }
            res[i] = stk.empty() ? i + 1 : i - stk.back();
            stk.push_back(i);
        }
        return res;
    }
    vector<int> smallestSubarrays3(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n);
        vector<int> stk;
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && (nums[i] | nums[stk.back()]) == nums[stk.back()]) {
                stk.pop_back();
            }
            res[i] = stk.empty() ? i + 1 : i - stk.back();
            stk.push_back(i);
        }
        return res;
    }
    vector<int> smallestSubarrays4(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n);
        vector<int> stk;
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && (nums[i] | nums[stk.back()]) == nums[stk.back()]) {
                stk.pop_back();
            }
            res[i] = stk.empty() ? i + 1 : i - stk.back();
            stk.push_back(i);
        }
        return res;
    }
};