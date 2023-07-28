class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int res = 0;
        int i = startPos, j = startPos;
        int sum = 0;
        while (j < n && j - i <= k) {
            sum += fruits[j][1];
            res = max(res, sum);
            ++j;
        }
        --j;
        while (i < n && j < n) {
            int t = i;
            while (t < n && fruits[t][0] < fruits[j][0] - k) {
                sum -= fruits[t][1];
                ++t;
            }
            i = t;
            while (j < n && fruits[j][0] - fruits[i][0] <= k) {
                sum += fruits[j][1];
                res = max(res, sum);
                ++j;
            }
        }
        return res;
    }
};