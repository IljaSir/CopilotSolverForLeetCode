class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        int p = 1;
        while (n > 0) {
            if (n & 1) {
                powers.push_back(p);
            }
            p <<= 1;
            n >>= 1;
        }
        int m = powers.size();
        vector<int> sums(m + 1, 1);
        for (int i = 0; i < m; ++i) {
            sums[i + 1] = (sums[i] * (long long)powers[i]) % 1000000007;
        }
        vector<int> ans;
        for (auto& q : queries) {
            int i = q[0];
            int j = q[1];
            ans.push_back((sums[j + 1] * (long long)pow(sums[i], 1000000005)) % 1000000007);
        }
        return ans;
    }
};