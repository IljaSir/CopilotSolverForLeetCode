class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> res;
        int n1 = nums1.size();
        int n2 = nums2.size();
        if (n1 == 0 || n2 == 0) return res;
        vector<int> idx(n1, 0);
        while (k-- && res.size() < n1 * n2) {
            int minSum = INT_MAX;
            int minIdx = -1;
            for (int i = 0; i < n1; ++i) {
                if (idx[i] < n2 && nums1[i] + nums2[idx[i]] < minSum) {
                    minSum = nums1[i] + nums2[idx[i]];
                    minIdx = i;
                }
            }
            res.push_back({nums1[minIdx], nums2[idx[minIdx]]});
            idx[minIdx]++;
        }
        return res;
    }
};