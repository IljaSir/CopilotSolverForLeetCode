class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        int n = nums.size();
        int res = 0;
        vector<int> sums(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        unordered_map<int, int> mp;
        for (int i = 0; i <= n; i++) {
            int t = sums[i] - goal;
            if (mp.count(t)) {
                res += mp[t];
            }
            mp[sums[i]]++;
        }
        return res;
    }
};