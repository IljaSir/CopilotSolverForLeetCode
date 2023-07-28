class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                left++;
                right = right > 0 ? right + 1 : 0;
            } else if (nums[i] < 0) {
                int tmp = left;
                left = right > 0 ? right + 1 : 0;
                right = tmp + 1;
            } else {
                left = 0;
                right = 0;
            }
            ans = max(ans, left);
        }
        return ans;
    }
};