class Solution {
public:
    int minDeletion(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res++;
                if (i + 2 < n && nums[i + 2] == nums[i]) {
                    nums[i + 1] = -1;
                }
            }
        }
        return res;
    }
};