class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        int n = needs.size();
        int N = 1 << n;
        vector<int> dp(N, 0);
        for (int i = 1; i < N; ++i) {
            int j = 0;
            while (!(i & (1 << j))) ++j;
            needs[j] -= 1;
            dp[i] = dp[i ^ (1 << j)] + price[j];
            for (auto& s : special) {
                int k = 0;
                for (; k < n; ++k) {
                    if (needs[k] < s[k]) break;
                }
                if (k == n) {
                    needs[j] += 1;
                    dp[i] = min(dp[i], dp[i ^ (1 << j)] + s[n]);
                    break;
                }
            }
            needs[j] += 1;
        }
        return dp[N - 1]iff < 0) break;
                clone[j] = diff;
            }
            if (j == needs.size()) {
                res = min(res, s.back() + dp(price, special, clone));
            }
        }
        return res;
    }
    int dot(vector<int>& a, vector<int>& b) {
        int sum = 0;
        for (int i = 0; i < a.size(); ++i) {
            sum += a[i] * b[i];
        }
        return sum;
    }
};