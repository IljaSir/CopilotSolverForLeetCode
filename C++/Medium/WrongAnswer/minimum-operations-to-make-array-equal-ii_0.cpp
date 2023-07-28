class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        int m = nums2.size();
        int sum1 = accumulate(nums1.begin(), nums1.end(), 0);
        int sum2 = accumulate(nums2.begin(), nums2.end(), 0);
        if (sum1 > sum2) {
            return minOperations(nums2, nums1, k);
        }
        if (sum1 + k < sum2) {
            return -1;
        }
        vector<int> diff;
        for (int i = 0; i < n; i++) {
            diff.push_back(nums1[i] - 1);
        }
        for (int i = 0; i < m; i++) {
            diff.push_back(6 - nums2[i]);
        }
        sort(diff.begin(), diff.end());
        int sum = 0;
        int ans = n + m;
        for (int i = 0; i < n + m; i++) {
            sum += diff[i];
            if (sum + k >= sum2) {
                ans = min(ans, i + 1);
            }
        }
        return ans;
    }
};