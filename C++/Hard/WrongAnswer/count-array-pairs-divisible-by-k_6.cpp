class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        unordered_map<int, int> mp;
        long long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (k == 1) {
                if (mp.find(nums[i]) != mp.end())
                    ans += mp[nums[i]];
            } else {
                if (mp.find(k - nums[i] % k) != mp.end())
                    ans += mp[k - nums[i] % k];
            }
            mp[nums[i] % k]++;
        }
        return ans;
    }
};