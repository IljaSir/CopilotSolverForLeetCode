class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        int n = deliciousness.size();
        unordered_map<int, int> mp;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int j = 0; j < 22; j++) {
                int target = 1 << j;
                if (mp.count(target - val)) {
                    res += mp[target - val];
                    res %= 1000000007;
                }
            }
            mp[val]++;
        }
        return res;
    }
};