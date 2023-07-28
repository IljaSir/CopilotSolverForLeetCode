class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        unordered_map<int, int> mp;
        long long res = 0;
        const int mod = 1e9 + 7;
        for (int num : nums) {
            int val = num - rev(num);
            res += mp[val];
            res %= mod;
            mp[val]++;
        }
        return res;
    }
    int rev(int n) {
        int res = 0;
        while (n) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
};