class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        
        unordered_map<int, int> m;
        for (int i : nums1) {
            for (int j : nums2) {
                m[i + j]++;
            }
        }
        int res = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                res += m[-i - j];
            }
        }
        return res;
    }
};