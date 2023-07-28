class Solution {
public:
    vector<int> sumZero(int n) {
        
        vector<int> res(n);
        if (n % 2 == 1) {
            res[n / 2] = 0;
        }
        for (int i = 1; i <= n / 2; i++) {
            res[n / 2 - i] = i;
            res[n / 2 + i - 1] = -i;
        }
        return res;
    }
};