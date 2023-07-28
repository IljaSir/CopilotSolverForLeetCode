class Solution {
public:
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        long long res = 0;
        int n = nums1.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums2[i] > nums2[j]) continue;
                int k = j + 1;
                while (k < n && nums1[k] < nums1[i]) ++k;
                while (k < n && nums1[k] > nums1[j]) ++k;
                res += k - j - 1;
            }
        }
        return res;
    }
};