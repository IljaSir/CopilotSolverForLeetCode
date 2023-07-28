class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        while(n) {
            powers.push_back(n & -n);
            n -= n & -n;
        }
        vector<int> res;
        for(auto& q: queries) {
            long long p = 1;
            for(int i = q[0]; i <= q[1]; ++i) {
                p = p * powers[i] % 1000000007;
            }
            res.push_back(p);
        }
        return res;
    }
};