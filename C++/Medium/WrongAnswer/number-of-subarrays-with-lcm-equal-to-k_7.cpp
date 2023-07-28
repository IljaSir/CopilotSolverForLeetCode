class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(k + 1);
        cnt[0] = 1;
        int res = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            cur = gcd(cur, nums[i]);
            if (cur == 1) {
                res += cnt[k];
            } else {
                for (int j = 2; j <= sqrt(cur); j++) {
                    if (cur % j == 0) {
                        res += cnt[j];
                        if (j * j != cur) res += cnt[cur / j];
                    }
                }
            }
            cnt[cur]++;
        }
        return res;
    }
};