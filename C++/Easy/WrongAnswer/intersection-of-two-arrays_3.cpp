class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_set<int> set1(nums1.begin(), nums1.end());
        unordered_set<int> set2(nums2.begin(), nums2.end());
        set1.insert(set2.begin(), set2.end());
        return vector<int>(set1.begin(), set1.end());
    }
};