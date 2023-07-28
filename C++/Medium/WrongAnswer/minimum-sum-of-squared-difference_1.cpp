class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        long long res = 0;
        int n = nums1.size();
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        for (int i = 0; i < n; ++i) {
            res += (long long)(nums1[i] - nums2[i]) * (nums1[i] - nums2[i]);
        }
        vector<pair<int, int>> diff;
        for (int i = 0; i < n; ++i) {
            if (nums1[i] > nums2[i]) {
                diff.push_back({nums1[i] - nums2[i], 1});
            } else if (nums1[i] < nums2[i]) {
                diff.push_back({nums2[i] - nums1[i], 2});
            }
        }
        sort(diff.begin(), diff.end());
        for (auto& p : diff) {
            if (p.second == 1 && k1 > 0) {
                res -= (long long)p.first * p.first * 2;
                --k1;
            } else if (p.second == 2 && k2 > 0) {
                res -= (long long)p.first * p.first * 2;
                --k2;
            }
            if (k1 == 0 && k2 == 0) {
                break;
            }
        }
        return res;
    }
};