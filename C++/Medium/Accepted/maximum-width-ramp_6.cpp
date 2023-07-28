class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        vector<int> v;
        for (int i = 0; i < n; i++) {
            if (v.empty() || nums[i] < nums[v.back()]) {
                v.push_back(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!v.empty() && nums[i] >= nums[v.back()]) {
                res = max(res, i - v.back());
                v.pop_back();
            }
        }
        return res;
    }
};