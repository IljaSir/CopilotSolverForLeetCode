class Solution {
public:
    int maxSum(vector<int>& nums1, vector<int>& nums2) {
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                sum1 += nums1[i];
                sum2 += nums2[j];
                sum1 = max(sum1, sum2);
                sum2 = sum1;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else {
                sum2 += nums2[j];
                j++;
            }
        }
        while (i < n1) {
            sum1 += nums1[i];
            i++;
        }
        while (j < n2) {
            sum2 += nums2[j];
            j++;
        }
        return max(sum1, sum2) % 1000000007;
    }
};