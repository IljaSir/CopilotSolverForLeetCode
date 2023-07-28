class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        if (k > n1 + n2) return -1;
        vector<int> v1(6, 0);
        vector<int> v2(6, 0);
        long long sum1 = 0;
        long long sum2 = 0;
        for (int i = 0; i < n1; ++i) {
            ++v1[nums1[i]];
            sum1 += nums1[i];
        }
        for (int i = 0; i < n2; ++i) {
            ++v2[nums2[i]];
            sum2 += nums2[i];
        }
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) {
            swap(v1, v2);
            swap(sum1, sum2);
        }
        int diff = sum2 - sum1;
        if (diff > k * 5) return -1;
        vector<int> dp(k + 1, 0);
        for (int i = 1; i <= 6; ++i) {
            for (int j = k; j >= 1; --j) {
                for (int x = 1; x <= v1[i - 1] && x <= j; ++x) {
                    dp[j] = max(dp[j], dp[j - x] + min(x, v2[7 - i]) * i);
                }
            }
        }
        return k - dp[k];
    }
};