class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        
        vector<int> result;
        unordered_map<int, int> map;
        for (auto i : nums1) map[i] |= 1;
        for (auto i : nums2) map[i] |= 2;
        for (auto i : nums3) map[i] |= 4;
        for (auto i : map) {
            if (i.second >= 2) result.push_back(i.first);
        }
        return result;
    }
};