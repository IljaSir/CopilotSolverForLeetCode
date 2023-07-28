class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        vector<int> sorted;
        for (int i = n - 1; i >= 0; i--) {
            res += distance(sorted.begin(), lower_bound(sorted.begin(), sorted.end(), nums[i]));
            sorted.insert(upper_bound(sorted.begin(), sorted.end(), 2 * (long)nums[i]), nums[i]);
        }
        return res;
    }
};