class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> ans(n);
        int i = 0, j = n - 1;
        for (int p = 1; p <= k + 1; p++) {
            ans[i++] = p % 2 ? j-- : j++;
        }
        for (int p = k + 2; p <= n; p++) {
            ans[i++] = p;
        }
        return ans;
    }
};