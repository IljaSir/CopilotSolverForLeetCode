class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        long long res = 0;
        unordered_map<int, int> mp;
        for (int num : nums) {
            int mod = num % k;
            if (mod < 0) mod += k;
            int t = (k - mod) % k;
            if (mp.count(t)) res += mp[t];
            ++mp[mod];
        }
        return res;
    }
};