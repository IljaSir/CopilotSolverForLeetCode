class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        multiset<int> s(nums1.begin(), nums1.end());
        for (int i = 0; i < nums2.size(); ++i) {
            auto it = s.upper_bound(nums2[i]);
            if (it == s.end()) {
                nums1[i] = *s.begin();
                s.erase(s.begin());
            } else {
                nums1[i] = *it;
                s.erase(it);
            }
        }
        return nums1;
    }
};