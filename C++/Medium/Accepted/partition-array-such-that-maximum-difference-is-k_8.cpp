class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int len = nums.size();
        int i = 0, j = 0;
        int ret = 0;
        while (i < len) {
            while (j < len && nums[j] - nums[i] <= k) {
                ++j;
            }
            ++ret;
            i = j;
        }
        return ret;
    }
};