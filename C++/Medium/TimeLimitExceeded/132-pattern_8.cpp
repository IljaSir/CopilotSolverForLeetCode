class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) {
            return false;
        }
        int minn = nums[0];
        for (int j = 1; j < n - 1; j++) {
            minn = min(minn, nums[j - 1]);
            for (int k = j + 1; k < n; k++) {
                if (nums[k] > minn && nums[k] < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
};