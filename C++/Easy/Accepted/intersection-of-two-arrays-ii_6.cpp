class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> res;
        int len1 = nums1.size();
        int len2 = nums2.size();
        if (len1 == 0 || len2 == 0) return res;
        unordered_map<int, int> m1;
        unordered_map<int, int> m2;
        for (int i = 0; i < len1; i++) {
            if (m1.find(nums1[i]) == m1.end()) {
                m1[nums1[i]] = 1;
            } else {
                m1[nums1[i]]++;
            }
        }
        for (int i = 0; i < len2; i++) {
            if (m2.find(nums2[i]) == m2.end()) {
                m2[nums2[i]] = 1;
            } else {
                m2[nums2[i]]++;
            }
        }
        for (auto it = m1.begin(); it != m1.end(); it++) {
            if (m2.find(it->first) != m2.end()) {
                int count = min(it->second, m2[it->first]);
                for (int i = 0; i < count; i++) {
                    res.push_back(it->first);
                }
            }
        }
        return res;
    }
};