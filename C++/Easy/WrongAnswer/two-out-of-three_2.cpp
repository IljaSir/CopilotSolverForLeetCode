class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        
        vector<int> res;
        unordered_map<int, int> m;
        for (int i : nums1) {
            m[i]++;
        }
        for (int i : nums2) {
            m[i]++;
        }
        for (int i : nums3) {
            m[i]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second >= 2) {
                res.push_back(it->first);
            }
        }
        return res;
    }
};