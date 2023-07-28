class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        while (n > 0) {
            int p = 1;
            while (p <= n) {
                p <<= 1;
            }
            powers.push_back(p >> 1);
            n -= p >> 1;
        }
        vector<int> res;
        for (auto& q : queries) {
            int p = 1;
            for (int i = q[0]; i <= q[1]; ++i) {
                p *= powers[i];
                p %= 1000000007;
            }
            res.push_back(p);
        }
        return res;
    }
};