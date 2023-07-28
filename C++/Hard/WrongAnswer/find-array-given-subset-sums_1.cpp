class Solution {
public:
    vector<int> recoverArray(int n, vector<int>& sums) {
        
        vector<int> ans(n, 0);
        int m = sums.size();
        vector<int> a(m, 0);
        for (int i = 0; i < m; ++i) {
            a[i] = sums[i];
        }
        sort(a.begin(), a.end());
        for (int i = 0; i < m; ++i) {
            if (i > 0 && a[i] == a[i-1]) {
                continue;
            }
            vector<int> b(m, 0);
            for (int j = 0; j < m; ++j) {
                b[j] = a[j] - a[i];
            }
            sort(b.begin(), b.end());
            if (b == a) {
                int x = a[i];
                for (int j = 0; j < n; ++j) {
                    ans[j] = x;
                    x = (x - a[i]) / 2;
                }
                break;
            }
        }
        return ans;
    }
};