class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        long long result = 0;
        vector<int> count(upper + 1, 0);
        for (int i = 0; i < nums.size(); i++) {
            int left = max(0, lower - nums[i]);
            int right = min(upper, upper - nums[i]);
            for (int j = left; j <= right; j++) {
                result += count[j];
            }
            count[nums[i]]++;
        }
        return result;
    }
};