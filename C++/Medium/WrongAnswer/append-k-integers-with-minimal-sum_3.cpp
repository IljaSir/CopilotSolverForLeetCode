class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        long long res = 0;
        for (int i = 0; i < nums.size() && k > 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            res += nums[i];
            k--;
        }
        if (k > 0) res += k;
        return res;
    }
};