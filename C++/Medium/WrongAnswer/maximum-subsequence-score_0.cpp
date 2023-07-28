class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        long long res = 0;
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (i > n || j > n) continue;
            long long s1 = 0, s2 = 0;
            vector<int> v1, v2;
            for (int p = 0; p < i; p++) {
                s1 += nums1[p];
                v1.push_back(nums1[p]);
            }
            for (int p = 0; p < j; p++) {
                s2 += nums2[p];
                v2.push_back(nums2[p]);
            }
            sort(v1.begin(), v1.end());
            sort(v2.begin(), v2.end());
            for (int p = 0; p < min(i, j) && v1[p] < v2[p]; p++) {
                s1 -= v1[p];
                s1 += v2[p];
            }
            res = max(res, s1 * s2);
        }
        return res;
    }
};