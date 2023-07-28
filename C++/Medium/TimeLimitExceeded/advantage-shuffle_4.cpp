class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> ans;
        sort(nums1.begin(), nums1.end());
        for (auto i : nums2) {
            auto it = upper_bound(nums1.begin(), nums1.end(), i);
            if (it == nums1.end()) {
                ans.push_back(nums1[0]);
                nums1.erase(nums1.begin());
            } else {
                ans.push_back(*it);
                nums1.erase(it);
            }
        }
        return ans;
    }
};