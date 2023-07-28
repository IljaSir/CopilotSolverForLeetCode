class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_set<int> s1;
        unordered_set<int> s2;
        for (int i = 0; i < nums1.size(); i++) {
            s1.insert(nums1[i]);
        }
        for (int i = 0; i < nums2.size(); i++) {
            s2.insert(nums2[i]);
        }
        vector<int> result;
        for (auto it = s1.begin(); it != s1.end(); it++) {
            int val = *it;
            if (s2.find(val) != s2.end()) {
                result.push_back(val);
            }
        }
        return result;
    }
};