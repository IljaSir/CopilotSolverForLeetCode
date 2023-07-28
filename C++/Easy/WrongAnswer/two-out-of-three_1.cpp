class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        
        vector<int> res;
        unordered_map<int, int> map;
        for (int i = 0; i < nums1.size(); i++) {
            map[nums1[i]]++;
        }
        for (int i = 0; i < nums2.size(); i++) {
            map[nums2[i]]++;
        }
        for (int i = 0; i < nums3.size(); i++) {
            map[nums3[i]]++;
        }
        for (auto i : map) {
            if (i.second >= 2) {
                res.push_back(i.first);
            }
        }
        return res;
    }
};