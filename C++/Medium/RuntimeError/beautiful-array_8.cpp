class Solution {
public:
    vector<int> beautifulArray(int n) {
        
        vector<int> res(n);
        int k = 0;
        for (int i = 1; i <= n; i *= 2) {
            for (int j = 0; j < n; ++j) {
                if (j % 2 == 0) {
                    res[k++] = i + j / 2;
                }
            }
        }
        for (int i = 1; i <= n; i *= 2) {
            for (int j = 0; j < n; ++j) {
                if (j % 2 == 1) {
                    res[k++] = i + j / 2;
                }
            }
        }
        return res;
    }
};