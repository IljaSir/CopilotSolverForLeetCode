class Solution {
public:
    int maxSum(vector<int>& nums1, vector<int>& nums2) {
        
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;
        int mod = 1e9 + 7;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j];
                j++;
            } else {
                ans += max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < nums1.size()) {
            sum1 += nums1[i];
            i++;
        }
        while (j < nums2.size()) {
            sum2 += nums2[j];
            j++;
        }
        ans += max(sum1, sum2);
        return ans % mod;
    }
};