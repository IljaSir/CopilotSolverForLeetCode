class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        
        int n = nums1.size();
        int res = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ++m[nums1[i] + nums2[j]];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res += m[-(nums3[i] + nums4[j])];
            }
        }
        return res;
    }
};