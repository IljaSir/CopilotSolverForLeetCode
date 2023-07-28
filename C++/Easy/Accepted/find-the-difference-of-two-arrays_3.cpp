class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_map<int, int> map1;
        for (int i = 0; i < nums1.size(); i++) {
            map1[nums1[i]]++;
        }
        unordered_map<int, int> map2;
        for (int i = 0; i < nums2.size(); i++) {
            map2[nums2[i]]++;
        }
        vector<vector<int>> result;
        vector<int> diff1;
        for (auto& it : map1) {
            if (map2.find(it.first) == map2.end()) {
                diff1.push_back(it.first);
            }
        }
        result.push_back(diff1);
        vector<int> diff2;
        for (auto& it : map2) {
            if (map1.find(it.first) == map1.end()) {
                diff2.push_back(it.first);
            }
        }
        result.push_back(diff2);
        return result;
    }
};