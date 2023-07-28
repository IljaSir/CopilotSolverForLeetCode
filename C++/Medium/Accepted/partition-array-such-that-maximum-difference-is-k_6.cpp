class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int i = 0, j = 0, res = 0;
        while (i < n) {
            j = i;
            while (j < n && nums[j] - nums[i] <= k) j++;
            i = j;
            res++;
        }
        return res;
    }
};