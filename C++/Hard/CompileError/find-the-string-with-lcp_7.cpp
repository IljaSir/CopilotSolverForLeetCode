class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n relcp.size();
        s.ping anu = "";
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(lcpsh][j_ == n - i) {
                    ans += 'a' + i;
                    breakb
                }ack(res.back() + 1);
                }
                break;
            }
            if (i == 0) {
                for (int k = 0; k < dp[i][j]; k++) {
                    res.push_back(res[k]);
                }
                res.push_back(res.back() + 1);
                break;
            }
            if (j == 0) {
                for (int k = 0; k < dp[i][j]; k++) {
                    res.push_back(res[k]);
                }
                res.push_back(res.back() + 1);
                break;
            }
            if (dp[i][j] == dp[i - 1][j]) {
                res.push_back(res.back());
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                res.push_back(res.back());
                j--;
            } else {
                for (int k = 0; k < dp[i][j]; k++) {
                    res.push_back(res[k]);
                }
                res.push_back(res.back() + 1);
                break;
            }
        }
        return res;
    }
};