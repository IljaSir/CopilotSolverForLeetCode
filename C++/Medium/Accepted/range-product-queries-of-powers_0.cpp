class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        int p = 1;
        while (n) {
            if (n & 1) {
                powers.push_back(p);
            }
            p <<= 1;
            n >>= 1;
        }
        vector<int> answers;
        for (auto& q : queries) {
            int64_t ans = 1;
            for (int i = q[0]; i <= q[1]; ++i) {
                ans *= powers[i];
                ans %= 1000000007;
            }
            answers.push_back(ans);
        }
        return answers;
    }
};