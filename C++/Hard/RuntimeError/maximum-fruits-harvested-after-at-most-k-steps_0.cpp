class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        vector<int> pos(n), amount(n);
        for (int i = 0; i < n; ++i) {
            pos[i] = fruits[i][0];
            amount[i] = fruits[i][1];
        }
        
        int ans = 0;
        for (int i = startPos; i >= 0 && k; --i, --k) {
            ans += amount[i];
        }
        int l = startPos - 1, r = startPos + 1;
        while (l >= 0 && r < n && k) {
            if (pos[l] + k >= pos[r]) {
                ans += amount[r];
                k -= pos[r] - pos[l] - 1;
                ++r;
            } else {
                ans += amount[l];
                k -= pos[l + 1] - pos[l] - 1;
                --l;
            }
        }
        while (l >= 0 && k) {
            ans += amount[l];
            k -= pos[l + 1] - pos[l] - 1;
            --l;
        }
        while (r < n && k) {
            ans += amount[r];
            k -= pos[r] - pos[r - 1] - 1;
            ++r;
        }
        return ans;
    }
};