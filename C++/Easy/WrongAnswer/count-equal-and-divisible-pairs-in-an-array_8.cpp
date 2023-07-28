class Solution {
public:
    int countPairs(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        map<int, int> mp;
        for (int i = 0; i < n; ++i) {
            if (k == 1) {
                res += mp[nums[i]];
            } else {
                for (int j = 1; j <= 100; ++j) {
                    if (nums[i] * j % k == 0) {
                        res += mp[nums[i] * j / k];
                    }
                }
            }
            ++mp[nums[i]];
        }
        return res;
    }
};