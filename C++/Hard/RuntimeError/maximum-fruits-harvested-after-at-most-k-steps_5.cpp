class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int res = 0, cur = 0, i = startPos;
        unordered_map<int, int> cnt;
        for (int j = 0; j < n; ++j) {
            ++cnt[fruits[j][0]];
            cur += fruits[j][1];
            if (cnt.size() > 2) {
                --cnt[fruits[i][0]];
                if (cnt[fruits[i][0]] == 0) cnt.erase(fruits[i][0]);
                cur -= fruits[i][1];
                ++i;
            }
            res = max(res, cur);
            if (i == startPos) k = 0;
            if (k > 0) {
                --k;
                ++i;
                if (i == n) i = 0;
            }
        }
        return res;
    }
};