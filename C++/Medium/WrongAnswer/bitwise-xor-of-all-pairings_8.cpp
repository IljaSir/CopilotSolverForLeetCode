class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        
        int res = 0;
        for (auto num : nums1) {
            res ^= num;
        }
        for (auto num : nums2) {
            res ^= num;
        }
        return res;
    }
    int xorAllPairs(vector<int>& nums1, vector<int>& nums2) {
        int res = 0;
        for (auto num1 : nums1) {
            for (auto num2 : nums2) {
                res ^= (num1 ^ num2);
            }
        }
        return res;
    }
};