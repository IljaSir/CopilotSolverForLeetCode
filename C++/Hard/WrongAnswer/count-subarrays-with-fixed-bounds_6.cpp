class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        
        long long count = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < nums.size(); ++j) {
                if (nums[j] < min) min = nums[j];
                if (nums[j] > max) max = nums[j];
                if (min >= minK && max <= maxK) {
                    ++count;
                }
            }
        }
        return count;
    }
};