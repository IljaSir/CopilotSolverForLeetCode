class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        
        vector<vector<int>> res;
        vector<int> v1, v2;
        unordered_map<int, int> m1, m2;
        for (auto& i : nums1) m1[i]++;
        for (auto& i : nums2) m2[i]++;
        for (auto& [k, v] : m1) {
            if (m2.find(k) == m2.end()) v1.push_back(k);
        }
        for (auto& [k, v] : m2) {
            if (m1.find(k) == m1.end()) v2.push_back(k);
        }
        res.push_back(v1);
        res.push_back(v2);
        return res;
    }
};