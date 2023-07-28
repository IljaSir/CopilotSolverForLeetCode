class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        int mod = 1e9 + 7;
        unordered_map<int, int> mp;
        int ans = 0;
        for (int i = 0; i < deliciousness.size(); i++) {
            for (int j = 0; j <= 20; j++) {
                int sum = (1 << j) - deliciousness[i];
                if (mp.find(sum) != mp.end()) {
                    ans += mp[sum];
                    ans %= mod;
                }
            }
            mp[deliciousness[i]]++;
        }
        return ans;
    }
};