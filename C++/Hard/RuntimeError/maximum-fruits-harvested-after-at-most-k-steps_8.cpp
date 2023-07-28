class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int left = startPos, right = startPos;
        int sum = 0;
        int maxSum = 0;
        vector<int> cnt(2 * 100000 + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum += fruits[i][1];
            cnt[fruits[i][0]] += fruits[i][1];
            while (left > 0 && right < n - 1 && left - 1 >= startPos - k && fruits[left - 1][0] == fruits[left][0]) {
                sum += fruits[left - 1][1];
                cnt[fruits[left - 1][0]] += fruits[left - 1][1];
                --left;
            }
            while (left > 0 && right < n - 1 && right + 1 <= startPos + k && fruits[right + 1][0] == fruits[right][0]) {
                sum += fruits[right + 1][1];
                cnt[fruits[right + 1][0]] += fruits[right + 1][1];
                ++right;
            }
            maxSum = max(maxSum, sum);
            if (left == 0 && right == n - 1) break;
            if (left > 0 && right < n - 1) {
                if (fruits[left - 1][0] < fruits[right + 1][0]) {
                    sum -= cnt[fruits[right][0]];
                    cnt[fruits[right][0]] = 0;
                    ++right;
                } else {
                    sum -= cnt[fruits[left][0]];
                    cnt[fruits[left][0]] = 0;
                    --left;
                }
            } else if (left > 0) {
                sum -= cnt[fruits[left][0]];
                cnt[fruits[left][0]] = 0;
                --left;
            } else {
                sum -= cnt[fruits[right][0]];
                cnt[fruits[right][0]] = 0;
                ++right;
            }
        }
        return maxSum;
    }
};