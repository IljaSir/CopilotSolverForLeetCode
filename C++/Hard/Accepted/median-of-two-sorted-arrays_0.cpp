class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> nums3;
        nums3.reserve(nums1.size() + nums2.size());
        nums3.insert(nums3.end(), nums1.begin(), nums1.end());
        nums3.insert(nums3.end(), nums2.begin(), nums2.end());
        sort(nums3.begin(), nums3.end());
        int size = nums3.size();
        if (size % 2 == 1) {
            return nums3[size/2];
        } else {
            return (nums3[size/2 - 1] + nums3[size/2]) / 2.0;
        }
    }
};