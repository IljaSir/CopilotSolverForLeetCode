class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.size();
        vector<int> l(n, 0);
        vector<int> r(n, 0);
        vector<int> mx(n, 0);
        vector<int> mn(n, 0);
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                l[i] = 0;
                mn[i] = s[i];
            } else {
                l[i] = s[i] - s[i - 1] > k ? 0 : l[i - 1] + 1;
                mn[i] = min(mn[i - 1], s[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) {
                r[i] = 0;
                mx[i] = s[i];
            } else {
                r[i] = s[i + 1] - s[i] > k ? 0 : r[i + 1] + 1;
                mx[i] = max(mx[i + 1], s[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, l[i] + r[i]);
            if (i < n - 1 && mx[i + 1] - mn[i] <= k) {
                ans = max(ans, l[i] + r[i + 1] + 1);
            }
        }
        return ans;
    }
};