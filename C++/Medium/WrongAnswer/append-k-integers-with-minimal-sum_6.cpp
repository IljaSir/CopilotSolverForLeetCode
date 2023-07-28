class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        for (auto &n : nums) sum += n;
        sort(nums.begin(), nums.end());
        int i = 0;
        while (i < nums.size() && k > 0) {
            if (i == 0 || nums[i] > nums[i - 1] + 1) {
                int x = nums[i] - (i > 0 ? nums[i - 1] + 1 : 1);
                if (x >= k) {
                    sum += k;
                    break;
                }
                sum += x;
                k -= x;
            }
            i++;
        }
        if (k > 0) sum += k;
        return sum;
    }
};