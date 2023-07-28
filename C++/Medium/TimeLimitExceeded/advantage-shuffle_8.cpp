class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        std::sort(nums1.begin(), nums1.end());
        std::vector<int> results;
        for (auto num : nums2) {
            auto it = std::upper_bound(nums1.begin(), nums1.end(), num);
            if (it != nums1.end()) {
                results.push_back(*it);
                nums1.erase(it);
            } else {
                results.push_back(nums1[0]);
                nums1.erase(nums1.begin());
            }
        }
        return results;
    }
};