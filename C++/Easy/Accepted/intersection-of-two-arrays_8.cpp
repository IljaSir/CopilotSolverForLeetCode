class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        set<int> s;
        vector<int> res;
        for (auto num : nums1) {
            s.insert(num);
        }
        for (auto num : nums2) {
            if (s.find(num) != s.end()) {
                res.push_back(num);
                s.erase(num);
            }
        }
        return res;
    }
};