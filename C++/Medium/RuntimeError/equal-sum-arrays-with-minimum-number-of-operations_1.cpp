class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        
        int sum1 = accumulate(nums1.begin(), nums1.end(), 0);
        int sum2 = accumulate(nums2.begin(), nums2.end(), 0);
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) {
            swap(nums1, nums2);
            swap(sum1, sum2);
        }
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end(), greater<int>());
        int i = 0, j = 0, res = 0;
        while (sum1 < sum2) {
            if (i < nums1.size() && j < nums2.size()) {
                if (6 - nums1[i] > nums2[j] - 1) {
                    sum1 += 6 - nums1[i];
                    ++i;
                } else {
                    sum2 -= nums2[j] - 1;
                    ++j;
                }
            } else if (i < nums1.size()) {
                sum1 += 6 - nums1[i];
                ++i;
            } else {
                sum2 -= nums2[j] - 1;
                ++j;
            }
            ++res;
        }
        return res;
    }
};