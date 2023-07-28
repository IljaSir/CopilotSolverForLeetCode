class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> ans(nums1.size());
        sort(nums1.begin(), nums1.end());
        for (int i = 0; i < nums2.size(); ++i) {
            int j = 0;
            while (j < nums1.size() && nums1[j] <= nums2[i]) {
                ++j;
            }
            if (j == nums1.size()) {
                j = 0;
                while (j < nums1.size() && nums1[j] <= nums2[i]) {
                    ++j;
                }
            }
            ans[i] = nums1[j];
            nums1.erase(nums1.begin() + j);
        }
        return ans;
    }
};