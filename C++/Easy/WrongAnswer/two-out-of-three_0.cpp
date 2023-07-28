class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        
        vector<int> res;
        map<int, int> m;
        for (int i = 0; i < nums1.size(); i++) {
            m[nums1[i]]++;
        }
        for (int i = 0; i < nums2.size(); i++) {
            m[nums2[i]]++;
        }
        for (int i = 0; i < nums3.size(); i++) {
            m[nums3[i]]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second >= 2) {
                res.push_back(it->first);
            }
        }
        return res;
    }
};