class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n - 2; ++i) {
            int l = i + 1, r = n;
            int s1 = sum[i];
            while (l < r) {
                int mid = l + (r - l) / 2;
                int s2 = sum[mid] - sum[i];
                int s3 = sum[n] - sum[mid];
                if (s2 >= s1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int s2 = sum[l] - sum[i];
            int s3 = sum[n] - sum[l];
            if (s2 < s1) {
                break;
            }
            if (s2 > s3) {
                continue;
            }
            int left = l, right = n;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                int s2 = sum[mid] - sum[i];
                int s3 = sum[n] - sum[mid];
                if (s2 <= s3) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            ans = (ans + left - l + 1) % 1000000007;
        }
        return ans;
    }
};