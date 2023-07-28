class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int n = nums.size();
        int ans = 0;
        int i = 0;
        int j = 0;
        int num = 0;
        while (j < n) {
            if (nums[j] >= left && nums[j] <= right) {
                // [i, j] is valid
                num = j - i + 1;
                ans += num;
            } else if (nums[j] < left) {
                // [i, j] is invalid
                ans += num;
            } else {
                // nums[j] > right
                i = j + 1;
                num = 0;
            }
            j++;
        }
        return ans;
    }
};