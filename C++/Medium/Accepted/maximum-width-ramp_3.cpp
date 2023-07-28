class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> s;
        for (int i = 0; i < n; ++i) {
            if (s.empty() || nums[s.back()] > nums[i]) {
                s.push_back(i);
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && nums[s.back()] <= nums[i]) {
                ans = max(ans, i - s.back());
                s.pop_back();
            }
        }
        return ans;
    }
};