class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return n;
        int res = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
            } else {
                res = max(res, curr);
                curr = 1;
            }
        }
        res = max(res, curr);
        return res;
    }
};