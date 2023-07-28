class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            bool flag = true;
            for (int j = 1; j < n; j++) {
                if (i == j) continue;
                if (nums[j - 1] >= nums[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
};