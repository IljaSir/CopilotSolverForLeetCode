class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        long long ans = 0;
        map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            int t = nums[i] - i;
            ans += mp[t];
            mp[t]++;
        }
        return ans;
    }
};