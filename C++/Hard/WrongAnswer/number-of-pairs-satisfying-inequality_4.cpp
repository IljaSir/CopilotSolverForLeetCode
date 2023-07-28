class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        int n = nums1.size();
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums1[i] - nums1[mid] <= nums2[i] - nums2[mid] + diff) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ans += n - l;
        }
        return ans;
    }
};