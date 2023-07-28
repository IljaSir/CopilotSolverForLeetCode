class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        
        int maxDistance = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] > nums2[j]) {
                i++;
                continue;
            }
            if (j - i > maxDistance) {
                maxDistance = j - i;
            }
            j++;
        }
        return maxDistance;
    }
};