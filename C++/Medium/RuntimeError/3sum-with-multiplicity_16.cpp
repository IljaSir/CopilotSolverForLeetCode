class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        vector<int> counts(101, 0);
        for (auto n : arr) {
            counts[n]++;
        }
        int res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) {
                    continue;
                }
                if (i == j && j == k) {
                    res += counts[i] * (counts[i] - 1) * (counts[i] - 2) / 6;
                } else if (i == j && j != k) {
                    res += counts[i] * (counts[i] - 1) / 2 * counts[k];
                } else if (i < j && j < k) {
                    res += counts[i] * counts[j] * counts[k];
                }
            }
        }
        return res % 1000000007;
    }
};