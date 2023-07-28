class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int ans = 0;
        int i = 0, j = 0;
        while (i < nums.size()) {
            while (j < nums.size() && nums[j] - nums[i] <= k) ++j;
            ++ans;
            i = j;
        }
        return ans;
    }
};