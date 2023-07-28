class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(k);
        long long res = 0;
        for (auto x : nums) {
            int y = x % k;
            if (y == 0) {
                res += cnt[0];
            } else {
                res += cnt[k - y];
            }
            cnt[y]++;
        }
        return res;
    }
};