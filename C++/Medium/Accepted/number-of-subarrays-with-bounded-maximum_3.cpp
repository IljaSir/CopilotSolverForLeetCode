class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int n = nums.size();
        int leftIdx = -1;
        int rightIdx = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                leftIdx = i;
            }
            if (nums[i] >= left) {
                rightIdx = i;
            }
            ans += rightIdx - leftIdx;
        }
        return ans;
    }
};