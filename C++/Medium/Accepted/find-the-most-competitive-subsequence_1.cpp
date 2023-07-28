class Solution {
public:
    vector<int> mostCompetitive(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> stk;
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && nums[i] < stk.back() && stk.size() + n - i > k) {
                stk.pop_back();
            }
            if (stk.size() < k) {
                stk.push_back(nums[i]);
            }
        }
        return stk;
    }
};