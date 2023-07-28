class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int mex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mex) {
                mex = nums[i] + value;
            } else {
                break;
            }
        }
        return mex;
    }
};