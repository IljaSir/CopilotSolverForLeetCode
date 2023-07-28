class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        
        vector<vector<int>> res;
        vector<int> v1, v2;
        unordered_map<int, int> m1, m2;
        for (auto &n: nums1) {
            m1[n]++;
        }
        for (auto &n: nums2) {
            m2[n]++;
        }
        for (auto &n: nums1) {
            if (m2[n] == 0) {
                v1.push_back(n);
            }
        }
        for (auto &n: nums2) {
            if (m1[n] == 0) {
                v2.push_back(n);
            }
        }
        res.push_back(v1);
        res.push_back(v2);
        return res;
    }
};