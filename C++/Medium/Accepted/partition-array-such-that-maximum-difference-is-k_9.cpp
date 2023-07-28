class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n == 1) {
            return 1;
        }
        int res = 1;
        sort(nums.begin(), nums.end());
        int left = 0, right = 1;
        while (right < n) {
            if (nums[right] - nums[left] > k) {
                res++;
                left = right;
            }
            right++;
        }
        return res;
    }
};