class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_set<int> s;
        for (auto n : nums1) s.insert(n);
        vector<int> ans;
        for (auto n : nums2) {
            if (s.count(n)) {
                ans.push_back(n);
                s.erase(n);
            }
        }
        return ans;
    }
};