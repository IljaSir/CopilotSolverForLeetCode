class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        map<int, int> m;
        for (auto i : nums1) {
            m[i]++;
        }
        vector<int> res;
        for (auto i : nums2) {
            if (m[i] > 0) {
                res.push_back(i);
                m[i]--;
            }
        }
        return res;
    }
};