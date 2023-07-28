class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                sum += nums[i];
            }
        }
        return sum + k;
    }
};