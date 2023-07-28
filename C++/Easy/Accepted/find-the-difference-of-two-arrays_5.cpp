class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        
        vector<vector<int>> result;
        vector<int> diff1;
        vector<int> diff2;
        unordered_map<int, int> m1;
        unordered_map<int, int> m2;
        for (int i = 0; i < nums1.size(); i++) {
            m1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.size(); i++) {
            m2[nums2[i]]++;
        }
        for (auto it = m1.begin(); it != m1.end(); it++) {
            if (m2.find(it->first) == m2.end()) {
                diff1.push_back(it->first);
            }
        }
        for (auto it = m2.begin(); it != m2.end(); it++) {
            if (m1.find(it->first) == m1.end()) {
                diff2.push_back(it->first);
            }
        }
        result.push_back(diff1);
        result.push_back(diff2);
        return result;
    }
};