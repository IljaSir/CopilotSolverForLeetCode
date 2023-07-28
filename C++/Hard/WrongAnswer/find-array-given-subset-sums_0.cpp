class Solution {
public:
    vector<int> recoverArray(int n, vector<int>& sums) {
        
        vector<int> ans(n, 0);
        sort(sums.begin(), sums.end());
        for (int i = 1; i < sums.size(); ++i) {
            ans[0] ^= sums[i] ^ sums[i-1];
        }
        ans[0] /= pow(2, n-1);
        for (int i = 1; i < n; ++i) {
            ans[i] = sums[0] ^ ans[0];
            for (int j = 0; j < sums.size(); ++j) {
                if (sums[j] == ans[i]) {
                    sums.erase(sums.begin() + j);
                    break;
                }
            }
        }
        return ans;
    }
};