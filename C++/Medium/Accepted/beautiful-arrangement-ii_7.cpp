class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> ans(n);
        int i = 0, j = n - 1, t = 0;
        while (i <= j) {
            ans[t++] = (k % 2) ? (i++ + 1) : (j-- + 1);
            if (k > 1) --k;
        }
        return ans;
    }
};