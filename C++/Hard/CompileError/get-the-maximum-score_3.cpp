class Solution {
public:
    int maxSum(vector<int>& nums1, vector<int>& nums2) {
        
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int res = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                res += nums1[i] + max(sum1, sum2);
                i++, j++;
                sum1 = 0, sum2 = 0;
            }
        }
        while (i < nums1.size()) {
            sum1 += nums1[i++];
        }
        while (j < nums2.size()) {
            sum2 += nums2[j++];
        }
        return res + max(sum1, sum2);
    }
    int maxSum(vector<int>& nums1, vector<int>& nums2) {
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int res = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                res += nums1[i] + max(sum1, sum2);
                i++, j++;
                sum1 = 0, sum2 = 0;
            }
        }
        while (i < nums1.size()) {
            sum1 += nums1[i++];
        }
        while (j < nums2.size()) {
            sum2 += nums2[j++];
        }
        return res + max(sum1, sum2);
    }
};