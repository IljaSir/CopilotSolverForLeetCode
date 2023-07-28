class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = firstLen; i <= n; i++) {
            int first = sum[i] - sum[i-firstLen];
            for (int j = secondLen; j <= n; j++) {
                if (i < j || j < i-firstLen) {
                    ans = max(ans, first + sum[j] - sum[j-secondLen]);
                }
            }
            for (int j = i+secondLen; j <= n; j++) {
                if (j < i || j > i+firstLen) {
                    ans = max(ans, first + sum[j] - sum[j-secondLen]);
                }
            }
        }
        for (int i = secondLen; i <= n; i++) {
            int first = sum[i] - sum[i-secondLen];
            for (int j = firstLen; j <= n; j++) {
                if (i < j || j < i-secondLen) {
                    ans = max(ans, first + sum[j] - sum[j-firstLen]);
                }
            }
            for (int j = i+firstLen; j <= n; j++) {
                if (j < i || j > i+secondLen) {
                    ans = max(ans, first + sum[j] - sum[j-firstLen]);
                }
            }
        }
        return ans;
    }
};