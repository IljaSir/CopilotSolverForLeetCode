class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        long long ans = 0;
        for (auto n : nums) {
            ans += n;
        }
        int i = 0;
        while (i < nums.size() && k > 0) {
            if (i == 0) {
                ans += k;
                k = 0;
            } else if (nums[i] == nums[i-1]) {
                i++;
            } else {
                int diff = nums[i] - nums[i-1];
                if (k >= diff) {
                    ans += diff * (long long)k;
                    k -= diff;
                    i++;
                } else {
                    ans += k;
                    k = 0;
                }
            }
        }
        return ans;
    }
};