class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        
        unordered_map<int, int> m;
        for (auto a : nums1) {
            for (auto b : nums2) {
                m[a + b]++;
            }
        }
        int res = 0;
        for (auto c : nums3) {
            for (auto d : nums4) {
                if (m.count(-c - d)) {
                    res += m[-c - d];
                }
            }
        }
        return res;
    }
};