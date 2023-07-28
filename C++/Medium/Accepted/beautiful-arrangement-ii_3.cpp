class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> ans(n);
        int i = 0;
        int l = 1, r = n;
        while (l < r) {
            if (k > 1) {
                ans[i++] = (k-- % 2) ? l++ : r--;
            } else {
                ans[i++] = l++;
            }
        }
        ans[i] = l;
        return ans;
    }
};