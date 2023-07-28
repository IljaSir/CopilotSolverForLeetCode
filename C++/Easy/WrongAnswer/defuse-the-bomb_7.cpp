class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        int n = code.size();
        vector<int> res(n);
        if (k == 0) return res;
        int sum = 0;
        for (int i = 1; i <= abs(k); i++) {
            sum += code[(n + k + i) % n];
        }
        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum -= code[(n + k + i + 1) % n];
            sum += code[(n + k + i + 1 + abs(k)) % n];
        }
        return res;
    }
};