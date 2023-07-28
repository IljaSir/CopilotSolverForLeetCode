class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        int MOD = 1e9 + 7;
        int mx = 0;
        for (int x: deliciousness) mx = max(mx, x);
        int maxSum = mx * 2;
        int pairs = 0;
        unordered_map<int, int> cnt;
        for (int x: deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int y = sum - x;
                if (cnt.count(y)) pairs = (pairs + cnt[y]) % MOD;
            }
            cnt[x]++;
        }
        return pairs;
    }
};