class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 1; i <= n; ++i) sum[i] = sum[i-1] + nums[i-1];
        unordered_map<int, int> mp;
        for (int i = 0; i <= n; ++i) {
            if (mp.count(sum[i])) return true;
            mp[sum[i]] = i;
        }
        return false;
    }
};