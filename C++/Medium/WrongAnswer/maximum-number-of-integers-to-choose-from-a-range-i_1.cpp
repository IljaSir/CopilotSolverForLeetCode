class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        sort(banned.begin(), banned.end());
        int res = 0;
        for (int i = 0; i < banned.size(); ++i) {
            if (banned[i] > maxSum) break;
            int j = i + 1;
            while (j < banned.size() && banned[j] == banned[j - 1] + 1) ++j;
            int low = i == 0 ? 1 : banned[i - 1] + 1;
            int high = j == banned.size() ? n : banned[j] - 1;
            if (low <= high) {
                int sum = (low + high) * (high - low + 1) / 2;
                if (sum > maxSum) {
                    int l = low, r = high;
                    while (l < r) {
                        int m = l + (r - l) / 2;
                        int s = (low + m) * (m - low + 1) / 2;
                        if (s <= maxSum) l = m + 1;
                        else r = m;
                    }
                    res += l - low;
                    break;
                }
                res += high - low + 1;
            }
            i = j - 1;
        }
        return res;
    }
};