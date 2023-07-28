class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int i = startPos, j = startPos;
        int res = 0;
        int cur = 0;
        int last = -1;
        while (i >= 0 || j < n) {
            if (i >= 0 && (j == n || fruits[i][0] >= fruits[j][0] - k)) {
                if (fruits[i][0] == last) {
                    cur += fruits[i][1];
                } else {
                    res = max(res, cur);
                    cur = fruits[i][1];
                    last = fruits[i][0];
                }
                --i;
            } else {
                if (fruits[j][0] == last) {
                    cur += fruits[j][1];
                } else {
                    res = max(res, cur);
                    cur = fruits[j][1];
                    last = fruits[j][0];
                }
                ++j;
            }
        }
        return res;
    }
};