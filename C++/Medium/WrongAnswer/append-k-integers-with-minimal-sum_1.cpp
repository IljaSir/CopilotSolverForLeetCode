class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] - nums[i - 1] > 1) {
                int diff = nums[i] - nums[i - 1] - 1;
                if (diff >= k) {
                    sum += k * (nums[i - 1] + 1);
                    return sum;
                } else {
                    k -= diff;
                    sum += diff * (nums[i - 1] + 1);
                }
            }
        }
        sum += k * (nums[nums.size() - 1] + 1);
        return sum;
    }
};