class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int ans = 0;
        int l = startPos, r = startPos;
        int cnt = 0;
        while (l >= 0 || r < n) {
            int lval = l >= 0 ? fruits[l][0] : -1;
            int rval = r < n ? fruits[r][0] : -1;
            if (lval == rval) {
                if (lval == -1) break;
                l--, r++;
                cnt++;
            } else if (lval == -1) {
                r++;
                cnt++;
            } else if (rval == -1) {
                l--;
                cnt++;
            } else {
                if (lval < rval) {
                    l--;
                    cnt++;
                } else {
                    r++;
                    cnt++;
                }
            }
            if (cnt <= k) {
                int sum = 0;
                for (int i = l + 1; i < r; i++) {
                    sum += fruits[i][1];
                }
                ans = max(ans, sum);
            }
        }
        return ans;
    }
};