class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_set<int> s;
        for (int n : nums1) s.insert(n);
        vector<int> res;
        for (int n : nums2) {
            if (s.count(n)) {
                res.push_back(n);
                s.erase(n);
            }
        }
        return res;
    }
};