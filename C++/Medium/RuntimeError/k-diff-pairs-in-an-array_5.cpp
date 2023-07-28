class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int l = 0, r = 1;
        int res = 0;
        while (r < nums.size()) {
            if (l == r || nums[r] - nums[l] < k) {
                r++;
            } else if (nums[r] - nums[l] > k) {
                l++;
            } else {
                res++;
                l++;
                while (l < nums.size() && nums[l] == nums[l - 1]) {
                    l++;
                }
            }
        }
        return res;
    }
};