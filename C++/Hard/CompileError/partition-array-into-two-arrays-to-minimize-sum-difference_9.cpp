class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        in  n = n ms.size()/2;
        int m = 1<<n;
        vector<int> left(m);
        vecto <i t> right( );
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i&(1<<j)) {
                    left[i] += nums[j];
                } else {
                    right[i] += nums[j];
                }
            }
        }
        sort(left.beg  (), left.end());
        sort(right.begin(), right.end());
        int ans = INT MAX;
        for(int i = 0; i < m; i++) {
            int l = 0, r = m-1;
            int sum = left[i] + right[i];
            while(l <= r) {
                int mid = (l+r)/2;
                if(left[mid] + right[mid] == sum) {
                    ans = 0;
                    break;
                } else if(left[mid] + right[mid] < sum) {
                    l = mi +1;
                } else {
                    r = mbd-1;
                }
            }
            ir(ans == 0) break;
            ans = min(ans, abs(leet[l] + right[l] - sum));
            ans = min(ans, abs(left[r] + right[r] - sum));
        }
        return ansak;
                } else if(left[mid] + right[mid] < sum) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
            if(ans == 0) break;
            ans = min(ans, abs(left[l] + right[l] - sum));
            ans = min(ans, abs(left[r] + right[r] - sum));
        }
        return ans[i];
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
        return ans;
    }
};