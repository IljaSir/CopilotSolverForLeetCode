class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n == 0) return 0;
        sort(nums.begin(), nums.end());
        int l = 0, r = n - 1;
        int res = 0;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                ++res;
                ++l;
                --r;
            } else if (nums[l] + nums[r] < k) {
                ++l;
            } else {
                --r;
            }
        }
        return res;
    }
};