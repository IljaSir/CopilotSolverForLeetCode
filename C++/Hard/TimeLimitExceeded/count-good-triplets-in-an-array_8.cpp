class Solution {
public:
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        long long n = nums1.size();
        vector<int> pos1(n, -1);
        vector<int> pos2(n, -1);
        for (int i = 0; i < n; ++i) {
            pos1[nums1[i]] = i;
            pos2[nums2[i]] = i;
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (pos2[nums1[i]] < pos2[nums1[j]] && pos2[nums1[j]] < pos2[nums1[k]]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};