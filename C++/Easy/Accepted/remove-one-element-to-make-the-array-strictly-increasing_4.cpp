class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            vector<int> nums2;
            for (int j = 0; j < n; j++) {
                if (j != i) nums2.push_back(nums[j]);
            }
            bool flag = true;
            for (int j = 1; j < n - 1; j++) {
                if (nums2[j] <= nums2[j - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
};