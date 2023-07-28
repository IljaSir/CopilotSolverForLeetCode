class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<int> res;
        int m = nums1.size(), n = nums2.size();
        for (int i = max(0, k - n); i <= min(k, m); ++i) {
            vector<int> tmp1 = maxArray(nums1, i);
            vector<int> tmp2 = maxArray(nums2, k - i);
            vector<int> tmp(k, 0);
            merge(tmp1, tmp2, tmp);
            if (greater(tmp, 0, res, 0)) res.swap(tmp);
        }
        return res;
    }
};