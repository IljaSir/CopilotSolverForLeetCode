class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int n = nums.size();
        int l = k;
        int r = k;
        int res = nums[k];
        int minVal = nums[k];
        while (l > 0 || r < n-1) {
            if (l > 0 && r < n-1) {
                if (nums[l-1] < nums[r+1]) {
                    r++;
                    minVal = min(minVal, nums[r]);
                } else {
                    l--;
                    minVal = min(minVal, nums[l]);
                }
            } else if (l > 0) {
                l--;
                minVal = min(minVal, nums[l]);
            } else {
                r++;
                minVal = min(minVal, nums[r]);
            }
            res = max(res, minVal * (r-l+1));
        }
        return res;
    }
};