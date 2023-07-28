class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int n = nums.size();
        int maxK = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                int k = -nums[i];
                if (k > maxK) {
                    maxK = k;
                }
            }
        }
        return maxK;
    }
    int largestInteger(vector<int>& nums) {
        int n = nums.size();
        int maxK = findMaxK(nums);
        if (maxK == -1) {
            return -1;
        }
        vector<bool> isExist(maxK + 1, false);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                isExist[nums[i]] = true;
            }
        }
        for (int i = maxK; i > 0; i--) {
            if (isExist[i] && isExist[-i]) {
                return i;
            }
        }
        return -1;
    }
};