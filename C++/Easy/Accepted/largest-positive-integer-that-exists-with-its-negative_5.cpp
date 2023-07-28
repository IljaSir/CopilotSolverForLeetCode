class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int n = nums.size();
        int maxK = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                if (find(nums.begin(), nums.end(), -nums[i]) != nums.end())
                    maxK = max(maxK, nums[i]);
            }
        }
        return maxK;
    }
};