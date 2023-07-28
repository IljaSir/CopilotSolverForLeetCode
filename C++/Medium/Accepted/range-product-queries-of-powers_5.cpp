class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        int num = 1;
        while (n) {
            if (n & 1) {
                powers.push_back(num);
            }
            num <<= 1;
            n >>= 1;
        }
        vector<int> res;
        for (auto& q: queries) {
            int left = q[0], right = q[1];
            int prod = 1;
            for (int i = left; i <= right; ++i) {
                prod = (long long) prod * powers[i] % 1000000007;
            }
            res.push_back(prod);
        }
        return res;
    }
};