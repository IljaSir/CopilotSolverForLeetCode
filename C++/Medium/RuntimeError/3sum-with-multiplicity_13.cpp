class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        vector<int> cnt(101, 0);
        for (int num : arr) {
            cnt[num]++;
        }
        long long res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k) {
                    res += cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                } else if (i == j && j != k) {
                    res += cnt[i] * (cnt[i] - 1) / 2 * cnt[k];
                } else if (j < k) {
                    res += cnt[i] * cnt[j] * cnt[k];
                }
            }
        }
        return res % (int)(1e9 + 7);
    }
};