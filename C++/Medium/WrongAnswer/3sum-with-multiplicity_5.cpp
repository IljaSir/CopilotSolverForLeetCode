class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        vector<int> count(101, 0);
        for (int i = 0; i < arr.size(); ++i) {
            count[arr[i]]++;
        }
        int res = 0;
        for (int i = 0; i <= 100; ++i) {
            for (int j = i; j <= 100; ++j) {
                int k = target - i - j;
                if (k < 0 || k > 100) continue;
                if (i == j && j == k) {
                    res += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j < k) {
                    res += count[i] * (count[i] - 1) / 2 * count[k];
                } else if (j < k) {
                    res += count[i] * count[j] * count[k];
                }
            }
        }
        return res % (int)(1e9 + 7);
    }
};