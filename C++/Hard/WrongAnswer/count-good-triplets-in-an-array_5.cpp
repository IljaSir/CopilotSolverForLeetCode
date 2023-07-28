class Solution {
public:
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        long long res = 0;
        int n = nums1.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums1[i] < nums1[j] && nums1[j] < nums1[k] && nums2[i] < nums2[j] && nums2[j] < nums2[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
};