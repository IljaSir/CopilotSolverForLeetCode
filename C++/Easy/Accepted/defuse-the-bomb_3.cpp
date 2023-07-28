class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        vector<int> res;
        int n = code.size();
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; ++j) {
                    sum += code[(i + j) % n];
                }
            } else if (k < 0) {
                for (int j = -1; j >= k; --j) {
                    sum += code[(i + j + n) % n];
                }
            }
            res.push_back(sum);
        }
        return res;
    }
};