class Solution {
public:
    int maxSum(vector<int>& nums1, vector<int>& nums2) {
        
        int i = 0, j = 0;
        long long int sum1 = 0, sum2 = 0, ans = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] == nums2[j]) {
                ans += max(sum1, sum2) + nums1[i];
                sum1 = sum2 = 0;
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
        while (i < nums1.size()) {
            sum1 += nums1[i];
            i++;
        }
        while (j < nums2.size()) {
            sum2 += nums2[j];
            j++;
        }
        ans += max(sum1, sum2);
        return ans % 1000000007;
    }
};