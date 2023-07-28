class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        
        multiset<int> s1(nums1.begin(), nums1.end());
        vector<int> res(nums1.size());
        for (int i = 0; i < nums2.size(); i++) {
            auto it = s1.upper_bound(nums2[i]);
            if (it != s1.end()) {
                res[i] = *it;
                s1.erase(it);
            } else {
                res[i] = *s1.begin();
                s1.erase(s1.begin());
            }
        }
        return res;
    }
};