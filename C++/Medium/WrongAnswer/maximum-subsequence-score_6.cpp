class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        const int n = nums1.size();
        vector<long long> sum1(k + 1, 0);
        vector<long long> sum2(k + 1, 0);
        for (int i = 0; i < k; ++i) {
            sum1[i + 1] = sum1[i] + nums1[i];
            sum2[i + 1] = sum2[i] + nums2[i];
        }
        long long ans = 0;
        for (int i = 0; i <= k; ++i) {
            int j = k - i;
            ans = max(ans, sum1[i] + sum2[j] - min(nums1[i], nums2[j]));
        }
        return ans;
    }
};