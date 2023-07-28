class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        //cout << nums1 << nums2 << endl;
        int n = nums1.size();
        int i = 0, j = 0;
        while (k1-- > 0) {
            if (i < n && j < n) {
                if (nums1[i] < nums2[j]) {
                    ++i;
                } else {
                    ++j;
                }
            } else if (i < n) {
                ++i;
            } else {
                ++j;
            }
        }
        //cout << i << j << endl;
        long long ans = 0;
        for (int k = 0; k < n; ++k) {
            ans += (long long)(nums1[k] - nums2[k]) * (nums1[k] - nums2[k]);
        }
        //cout << ans << endl;
        while (k2-- > 0) {
            if (i < n && j < n) {
                if (nums1[i] < nums2[j]) {
                    ans += (long long)(nums2[j] - nums1[i]) * (nums2[j] - nums1[i]);
                    ans -= (long long)(nums1[i] - nums2[k]) * (nums1[i] - nums2[k]);
                    ++i;
                    ++j;
                } else {
                    ans += (long long)(nums1[i] - nums2[j]) * (nums1[i] - nums2[j]);
                    ans -= (long long)(nums2[j] - nums1[k]) * (nums2[j] - nums1[k]);
                    ++i;
                    ++j;
                }
            } else if (i < n) {
                ans += (long long)(nums1[i] - nums2[k]) * (nums1[i] - nums2[k]);
                ++i;
            } else {
                ans += (long long)(nums2[j] - nums1[k]) * (nums2[j] - nums1[k]);
                ++j;
            }
        }
        return ans;
    }
};