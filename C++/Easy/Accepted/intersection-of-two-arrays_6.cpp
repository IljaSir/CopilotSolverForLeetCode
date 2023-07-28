class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_map<int, int> m;
        vector<int> result;
        for (int i = 0; i < nums1.size(); i++) {
            m[nums1[i]]++;
        }
        for (int i = 0; i < nums2.size(); i++) {
            if (m[nums2[i]] > 0) {
                result.push_back(nums2[i]);
                m[nums2[i]] = 0;
            }
        }
        return result;
    }
};