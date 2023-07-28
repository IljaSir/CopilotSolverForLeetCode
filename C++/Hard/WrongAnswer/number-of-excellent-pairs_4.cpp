class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        int n = nums.size();
        int cnt[64] = {0};
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j < 64; j++) {
                if (x & (1LL << j)) {
                    cnt[j]++;
                }
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            long long s = 0;
            for (int j = 0; j < 64; j++) {
                if ((x & (1LL << j)) || (cnt[j] > 0)) {
                    s++;
                }
            }
            if (s >= k) {
                ans += n;
            } else {
                for (int j = i + 1; j < n; j++) {
                    int y = nums[j];
                    long long s = 0;
                    for (int k = 0; k < 64; k++) {
                        if ((x & (1LL << k)) || (y & (1LL << k)) || (cnt[k] > 0)) {
                            s++;
                        }
                    }
                    if (s >= k) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};