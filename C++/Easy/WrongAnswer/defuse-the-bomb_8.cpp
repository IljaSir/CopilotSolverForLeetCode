class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        int n = code.size();
        vector<int> ans(n);
        if (k == 0) return ans;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += code[i];
        }
        for (int i = 0; i < n; ++i) {
            if (k > 0) {
                ans[i] = sum - code[(i + n - k) % n];
            } else {
                ans[i] = sum - code[(i + k + n) % n];
            }
        }
        return ans;
    }
};