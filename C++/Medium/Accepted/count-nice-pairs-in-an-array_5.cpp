class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        unordered_map<long, long> m;
        long res = 0;
        for (int n : nums) {
            long rev = 0, x = n;
            while (x) {
                rev = rev * 10 + x % 10;
                x /= 10;
            }
            res += m[rev - n]++;
        }
        return res % (long)(1e9 + 7);
    }
};