class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        int n = code.size();
        vector<int> ans(n, 0);
        if (k == 0) return ans;
        int sum = 0;
        for (int i = 0; i < abs(k); i++) {
            sum += code[(i + 1) % n];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            sum -= code[(i + 1) % n];
            sum += code[(i + 1 + abs(k)) % n];
        }
        return ans;
    }
};