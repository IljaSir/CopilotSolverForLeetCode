class Solution {
public:
    int maxSum(vector<int>& nums1, vector<int>& nums2) {
        
        int m = nums1.size(), n = nums2.size(), i = 0, j = 0, sum1 = 0, sum2 = 0;
        while (i < m || j < n) {
            if (i < m && (j == n || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < n && (i == m || nums1[i] > nums2[j])) {
                sum2 += nums2[j++];
            } else {
                sum1 = sum2 = max(sum1, sum2) + nums1[i];
                i++;
                j++;
            }
        }
        return max(sum1, sum2) % 1000000007;
    }
};