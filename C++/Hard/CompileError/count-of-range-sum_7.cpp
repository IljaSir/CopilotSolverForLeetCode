class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        
        vector<long> sums(nums.size()+1);
        for (int i=0; i<nums.size(); i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        return countRangeSumRecursive(sums, 0, sums.size(), lower, upper);
    }
};