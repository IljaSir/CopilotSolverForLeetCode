class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size(), i = 0, j = n - 1, res = 0;
        while (i < j) {
            if (nums[i] * 2 <= nums[j]) {
                ++res;
                ++i;
            }
            --j;
        }
        return res;
    }
};