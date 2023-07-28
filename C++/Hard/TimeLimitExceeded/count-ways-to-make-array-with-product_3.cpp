class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        int n = 10001;
        vector<int> dp(n, 1);
        for (int i = 2; i < n; ++i) {
            for (int j = i; j < n; j += i) {
                dp[j]++;
            }
        }
        vector<int> ans;
        for (auto& q : queries) {
            int n = q[0];
            int k = q[1];
            int res = 1;
            for (int i = 2; i <= k; ++i) {
                int cnt = 0;
                while (k % i == 0) {
                    cnt++;
                    k /= i;
                }
                res = (long long)res * dp[i] % 1000000007;
                res = (long long)res * pow(i, cnt * n - 1) % 1000000007;
            }
            ans.push_back(res);
        }
        return ans;
    }
    int pow(int a, int n) {
        int res = 1;
        while (n) {
            if (n & 1) {
                res = (long long)res * a % 1000000007;
            }
            a = (long long)a * a % 1000000007;
            n >>= 1;
        }
        return res;
    }
};