class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        vector<int> pre(n, 0);
        pre[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            pre[i] = pre[i-1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int firstSum = 0;
            if (i + firstLen - 1 < n) {
                firstSum = pre[i + firstLen - 1] - (i > 0 ? pre[i-1] : 0);
            }
            for (int j = 0; j < n; ++j) {
                if (j + secondLen - 1 < n) {
                    int secondSum = 0;
                    if (i > j + secondLen - 1 || i + firstLen - 1 < j) {
                        secondSum = pre[j + secondLen - 1] - (j > 0 ? pre[j-1] : 0);
                    }
                    ans = max(ans, firstSum + secondSum);
                }
            }
        }
        return ans;
    }
};