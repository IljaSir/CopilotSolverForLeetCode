class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        for (int i = 0; i <= 30; ++i) {
            if (n & (1 << i)) {
                powers.push_back(1 << i);
            }
        }
        int m = queries.size();
        vector<int> ans(m);
        for (int i = 0; i < m; ++i) {
            long long prod = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; ++j) {
                prod = prod * powers[j] % 1000000007;
            }
            ans[i] = prod;
        }
        return ans;
    }
};