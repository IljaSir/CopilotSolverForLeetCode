class Solution {
public:
    int destroyTargets(vector<int>& nums, int space) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int res = 1;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && nums[j] - nums[i] <= space) {
                ++j;
            }
            res = max(res, j - i);
        }
        return res;
    }
};