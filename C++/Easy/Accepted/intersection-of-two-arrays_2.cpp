class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_set<int> set1;
        unordered_set<int> set2;
        for (auto num: nums1) {
            set1.insert(num);
        }
        for (auto num: nums2) {
            set2.insert(num);
        }
        vector<int> result;
        for (auto num: set1) {
            if (set2.find(num) != set2.end()) {
                result.push_back(num);
            }
        }
        return result;
    }
};