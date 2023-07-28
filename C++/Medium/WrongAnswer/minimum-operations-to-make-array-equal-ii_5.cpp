class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        int m = nums2.size();
        vector<int> diff;
        for (int i = 0; i < n; ++i) {
            diff.push_back(nums1[i] - nums2[i]);
        }
        sort(diff.begin(), diff.end());
        long long sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += diff[i];
        }
        if (sum >= 0) return 0;
        long long ans = (long long)1e18;
        for (int i = k - 1; i >= 0; --i) {
            sum -= diff[i];
            sum += -diff[n - k + i];
            if (sum >= 0) {
                ans = min(ans, (long long)2 * (k - i));
            }
        }
        return ans == (long long)1e18 ? -1 : ans;
    }
};