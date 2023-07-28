class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        int l = 0, r = n;
        sort(banned.begin(), banned.end());
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(banned, n, maxSum, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    bool check(vector<int>& banned, int n, int maxSum, int k) {
        int sum = 0, i = 0;
        for (int j = 1; j <= k; ++j) {
            while (i < banned.size() && banned[i] < j) {
                ++i;
            }
            sum += (j - i);
        }
        return sum <= maxSum;
    }
};