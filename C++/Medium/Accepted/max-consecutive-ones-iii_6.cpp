class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        int l = 0;
        int r = 0;
        int zeroCnt = 0;
        while (r < n) {
            if (nums[r] == 0) {
                zeroCnt++;
            }
            while (zeroCnt > k) {
                if (nums[l] == 0) {
                    zeroCnt--;
                }
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};