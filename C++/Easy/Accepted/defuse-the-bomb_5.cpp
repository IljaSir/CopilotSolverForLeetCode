class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        int n = code.size();
        vector<int> res(n, 0);
        if (k == 0) {
            return res;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += code[i];
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int j = i + 1; j <= i + k; j++) {
                    s += code[j % n];
                }
                res[i] = s;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int j = i + n + k; j < i + n; j++) {
                    s += code[j % n];
                }
                res[i] = s;
            }
        }
        return res;
    }
};