class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> res(n);
        int i = 0, j = n - 1;
        int cnt = 1;
        while (i <= j) {
            if (k > 1) {
                res[i++] = cnt++;
                res[j--] = cnt + k - 2;
                cnt += k - 1;
                k -= 2;
            } else {
                res[i++] = cnt++;
            }
        }
        return res;
    }
};