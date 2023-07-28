class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            if (i == 0) {
                sum += nums[i];
            } else {
                if (nums[i] != nums[i-1]) {
                    sum += nums[i];
                }
            }
        }
        
        int i = 1;
        while (k > 0) {
            if (i >= nums.size() || nums[i] != nums[i-1]) {
                sum += nums[i-1] + 1;
                k--;
            }
            i++;
        }
        
        return sum;
    }
};