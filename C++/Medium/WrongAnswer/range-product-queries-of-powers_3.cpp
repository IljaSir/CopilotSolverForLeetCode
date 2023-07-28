class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        for (int i = 0; i < 31; i++) {
            if (n & (1 << i)) {
                powers.push_back(1 << i);
            }
        }
        int m = powers.size();
        vector<int> prefix(m + 1);
        for (int i = 1; i <= m; i++) {
            prefix[i] = prefix[i - 1] + powers[i - 1];
        }
        vector<int> ret;
        for (auto &query : queries) {
            int l = query[0], r = query[1];
            int p = prefix[r + 1] - prefix[l];
            ret.push_back(p);
        }
        return ret;
    }
};