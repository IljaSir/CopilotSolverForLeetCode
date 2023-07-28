class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        
        set<int> s1;
        set<int> s2;
        for (int i = 0; i < nums1.size(); i++) {
            s1.insert(nums1[i]);
        }
        for (int i = 0; i < nums2.size(); i++) {
            s2.insert(nums2[i]);
        }
        vector<int> v1;
        vector<int> v2;
        for (auto it = s1.begin(); it != s1.end(); it++) {
            if (s2.find(*it) == s2.end()) {
                v1.push_back(*it);
            }
        }
        for (auto it = s2.begin(); it != s2.end(); it++) {
            if (s1.find(*it) == s1.end()) {
                v2.push_back(*it);
            }
        }
        return {v1, v2};
    }
};