class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        
        unordered_map<int, int> map;
        int count = 0;
        for (auto i : nums1) {
            for (auto j : nums2) {
                map[i + j]++;
            }
        }
        for (auto i : nums3) {
            for (auto j : nums4) {
                if (map.find(0 - i - j) != map.end()) {
                    count += map[0 - i - j];
                }
            }
        }
        return count;
    }
};