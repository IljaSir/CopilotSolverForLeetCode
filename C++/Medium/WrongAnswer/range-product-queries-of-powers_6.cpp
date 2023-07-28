class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        int p = 1;
        while (p <= n) {
            powers.push_back(p);
            p *= 2;
        }
        vector<int> ans;
        for (auto& q: queries) {
            int product = 1;
            for (int i = q[0]; i <= q[1]; ++i) {
                product = (product * powers[i]) % (1000000000 + 7);
            }
            ans.push_back(product);
        }
        return ans;
    }
};