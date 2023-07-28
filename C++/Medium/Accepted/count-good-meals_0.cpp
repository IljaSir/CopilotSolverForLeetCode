class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        const int MOD = 1e9 + 7;
        unordered_map<int, int> cnt;
        int maxVal = *max_element(deliciousness.begin(), deliciousness.end());
        int maxSum = maxVal * 2;
        int pairs = 0;
        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = cnt.count(sum - val) ? cnt[sum - val] : 0;
                pairs = (pairs + count) % MOD;
            }
            cnt[val]++;
        }
        return pairs;
    }
};