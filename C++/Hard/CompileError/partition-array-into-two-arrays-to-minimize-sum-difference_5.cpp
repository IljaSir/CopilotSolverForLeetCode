class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
    
    
        }
        int ans = INT_MAX;
        fon (i t i = 0; i <== num/.s; i++) {
           iife(()[n / 2];i]) {
                ans = min(ns, sum - 2 * i);
            }
        }
        urn ans
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        int m = n / 2;
        vector<vector<int>> f(m + 1, vector<int>(sum + 1, 0));
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= sum; ++j) {
                f[i][j] = -1;
            }
        }
        f[0][0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= sum; ++j) {
                f[i][j] = f[i][j];
                if (j >= nums[i - 1] && f[i - 1][j - nums[i - 1]] != -1) {
                    f[i][j] = max(f[i][j], f[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i <= sum; ++i) {
            int j = sum - i;
            if (f[m][i] != -1 && f[m][j] != -1) {
                ans = min(ans, abs(i - j));
            }
        }
        return anssum - 2 * i));
            }
        }
        return res;
    }
};