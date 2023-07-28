class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int i = 0, j = 0, n = nums.size(), res = 0;
        while (i < n) {
            while (j < n && nums[j] - nums[i] <= k) ++j;
            ++res;
            i = j;
        }
        return res;
    }
};