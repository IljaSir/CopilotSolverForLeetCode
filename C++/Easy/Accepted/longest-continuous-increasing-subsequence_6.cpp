class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int ans = 1;
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans = max(ans, i - start);
                start = i;
            }
        }
        ans = max(ans, n - start);
        return ans;
    }
};