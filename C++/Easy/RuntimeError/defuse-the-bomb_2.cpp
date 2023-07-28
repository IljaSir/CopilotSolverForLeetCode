class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        int n = code.size();
        vector<int> res(n, 0);
        if (k == 0) return res;
        int sum = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                res[i] = sum;
                sum += code[(i + k + 1) % n];
                sum -= code[(i + 1) % n];
            }
        } else {
            for (int i = n - 1; i >= n + k; i--) {
                sum += code[i % n];
            }
            for (int i = 0; i < n; i++) {
                res[i] = sum;
                sum += code[(i + k) % n];
                sum -= code[(i - 1 + n) % n];
            }
        }
        return res;
    }
};