class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_set<int> s1(nums1.begin(), nums1.end());
        unordered_set<int> s2(nums2.begin(), nums2.end());
        vector<vector<int>> res;
        vector<int> v1, v2;
        for (int i = 0; i < nums1.size(); ++i) {
            if (s2.find(nums1[i]) == s2.end()) {
                v1.push_back(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.size(); ++i) {
            if (s1.find(nums2[i]) == s1.end()) {
                v2.push_back(nums2[i]);
            }
        }
        res.push_back(v1);
        res.push_back(v2);
        return res;
    }
};