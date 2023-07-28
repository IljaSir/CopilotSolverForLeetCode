class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int n = nums.size();
        int l = k, r = k;
        int res = 0;
        int minNum = nums[k];
        while (l >= 0 || r < n) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else if (nums[l - 1] < nums[r + 1]) {
                r++;
            } else {
                l--;
            }
            minNum = min(minNum, min(nums[l], nums[r]));
            res = max(res, minNum * (r - l + 1));
        }
        return res;
    }
};