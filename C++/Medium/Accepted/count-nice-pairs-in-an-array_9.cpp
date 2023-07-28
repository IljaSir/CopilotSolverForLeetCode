class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        int res = 0;
        unordered_map<long long, int> cnt;
        const int mod = 1e9 + 7;
        for (auto& num : nums) {
            long long rev = 0, tmp = num;
            while (tmp) {
                rev = rev * 10 + tmp % 10;
                tmp /= 10;
            }
            res = (res + cnt[num - rev]) % mod;
            cnt[num - rev]++;
        }
        return res;
    }
};