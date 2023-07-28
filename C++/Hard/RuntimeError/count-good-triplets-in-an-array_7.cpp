class Solution {
public:
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> cnt1(n), cnt2(n);
        for (int i = 0; i < n; ++i) {
            ++cnt1[nums1[i]];
            ++cnt2[nums2[i]];
        }
        for (int i = 1; i < n; ++i) {
            cnt1[i] += cnt1[i - 1];
            cnt2[i] += cnt2[i - 1];
        }
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums1[i] < nums1[j] && nums1[j] < nums1[k] && nums2[i] < nums2[j] && nums2[j] < nums2[k]) {
                        res += 1LL * cnt1[nums1[i] - 1] * cnt2[nums2[k]] - 1LL * cnt1[nums1[j]] * cnt2[nums2[j] - 1];
                    }
                }
            }
        }
        return res;
    }
};