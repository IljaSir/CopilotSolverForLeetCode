class Solution {
public:
    int getLengthOfOptimalCompression(string s, int k) {
        
 ++i) {
           for (nt j = 0; j <= k; j
    if (dp[i][j] == n + 1) {
                    continue;
                }
                int c = 1;
                 l = i + 1; l <= n; ++l) {
                    int cost = c <= 1 ? 1 : c <= 9 ? 2 : c <= 99 ? 3 : 4;
                   if (j + l - i - c <= k) {
                        dp[l][j + l - i - c] = min(dp[l][ + l - i - c], dp[i][j] + cost);
                    }
                    if (l < n&& s[l] = s[i]) {
                        ++c;
                   } else {
                        break;
                    }
                }
            }
        }
        return *min_element(dp[n].begin(), dp[n].end());
    }
};