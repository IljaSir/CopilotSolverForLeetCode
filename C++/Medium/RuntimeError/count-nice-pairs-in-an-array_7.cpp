class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        unordered_map<int, int> cache;
        int res = 0;
        for (auto num : nums) {
            int rev = 0;
            int tmp = num;
            while (tmp) {
                rev = rev * 10 + tmp % 10;
                tmp /= 10;
            }
            int diff = num - rev;
            if (cache.count(diff)) {
                res += cache[diff];
            }
            cache[diff]++;
        }
        return res % 1000000007;
    }
};