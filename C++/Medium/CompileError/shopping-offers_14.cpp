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
            for (a to& s : special) {
                int k = 0;
                for (; k < n; ++k) {
                    if (needs[k] < s[k]) break;
                }
                if (k == n) {
                    needs[j] += 1;
                    dp[i] =  in(dp[i], dp[i ^ (1 << j)] + s[n]);
                    break;
                }
            }
            needs[j] += 1;
        }
        return dp[N - 1]   tmp = -1;
                        break;
                    }
                    tmp >>= 1;
                }
                if (tmp != -1) {
                    dp[i | (1 << n)] = min(dp[i | (1 << n)], dp[i] + special[j][n]);
                }
            }
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    dp[i] = min(dp[i], dp[i ^ (1 << j)] + price[j]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};