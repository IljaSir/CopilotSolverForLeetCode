class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        vector<int> res;
        for (auto& q : queries) {
            int n = q[0], k = q[1];
            long long ans = 1;
            for (int i = 2; i * i <= k; ++i) {
                if (k % i == 0) {
                    int e = 0;
                    while (k % i == 0) {
                        ++e;
                        k /= i;
                    }
                    long long cur = 1;
                    for (int j = 0; j < e; ++j) {
                        cur = cur * (n + j) % 1000000007;
                    }
                    for (int j = 2; j <= e; ++j) {
                        cur = cur * inv[j] % 1000000007;
                    }
                    ans = ans * cur % 1000000007;
                }
            }
            if (k > 1) {
                ans = ans * n % 1000000007;
            }
            res.push_back(ans);
        }
        return res;
    }
};