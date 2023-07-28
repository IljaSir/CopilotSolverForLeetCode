class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        vector<int> min(n, 0);
        min[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            min[i] = min[i-1] < nums[i] ? min[i-1] : nums[i];
        }
        for (int i = n-1; i >= 0; --i) {
            for (int j = i-1; j >= 0; --j) {
                if (nums[j] > min[j] && nums[j] < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
};