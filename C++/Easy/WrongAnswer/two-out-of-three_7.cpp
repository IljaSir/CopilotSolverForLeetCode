class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        
        vector<int> ret;
        unordered_map<int, int> m;
        for (int num : nums1) {
            m[num]++;
        }
        for (int num : nums2) {
            m[num]++;
        }
        for (int num : nums3) {
            m[num]++;
        }
        for (auto it : m) {
            if (it.second >= 2) {
                ret.push_back(it.first);
            }
        }
        return ret;
    }
};