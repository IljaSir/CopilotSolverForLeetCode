class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> res(nums1.size(), 0);
        sort(nums1.begin(), nums1.end());
        for (int i = 0; i < nums2.size(); i++) {
            auto it = upper_bound(nums1.begin(), nums1.end(), nums2[i]);
            if (it == nums1.end()) {
                res[i] = nums1[0];
                nums1.erase(nums1.begin());
            } else {
                res[i] = *it;
                nums1.erase(it);
            }
        }
        return res;
    }
};