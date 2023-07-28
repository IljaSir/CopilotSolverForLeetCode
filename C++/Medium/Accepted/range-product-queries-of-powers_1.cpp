class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        for (int i = 0; i < 31; i++) {
            if (n & (1 << i)) {
                powers.push_back(1 << i);
            }
        }
        vector<int> ans;
        for (auto q : queries) {
            int prod = 1;
            for (int i = q[0]; i <= q[1]; i++) {
                prod = (prod * 1LL * powers[i]) % 1000000007;
            }
            ans.push_back(prod);
        }
        return ans;
    }
};