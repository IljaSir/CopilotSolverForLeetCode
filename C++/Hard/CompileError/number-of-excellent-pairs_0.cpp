class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<int> cnt(60, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 60; ++j) {
                if ((nums[i] >> j) & 1) {
                    ++cnt[j];
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = 0; j < 60; ++j) {
                if ((nums[i] >> j) & 1) {
                    cur += cnt[j];
                }
            }
            ans += cur - 1;
        }
        ans /= 2;
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = 0; j < 60; ++j) {
                if ((nums[i] >> j) & 1) {
                    cur += n;
                } else {
                    cur += cnt[j];
                }
            }
            ans += cur - 1;
        }
        ans /= 2;
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = 0; j < 60; ++j) {
                if ((nums[i] >> j) & 1) {
                    cur += n;
                } else {
                    cur += cnt[j];
                }
            }
            ans -= cur - 1;
        }
        ans /= 2;
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = 0; j < 60; ++j) {
                if ((nums[i] >> j) & 1) {
                    cur += cnt[j];
                }
            }
            ans -= cur - 1;
        }
        ans /= 2;
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = 0; j < 60; ++j) {
                if ((nums[i] >> j) & 1) {
                    cur += cnt[j];
                }
            }
    }
};