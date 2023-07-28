class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int diff) {
        
        int n = nums1.size();
        vector<int> cnt(n + 1, 0);
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums1[i] - nums2[i] > nums1[mid] - nums2[mid] + diff) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            ans += i - l;
            l = 0, r = n;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums1[i] - nums2[i] >= nums1[mid] - nums2[mid] + diff) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            cnt[l]++;
        }
        for (int i = 0; i < n; i++) {
            ans += cnt[i] * (cnt[i] - 1) / 2;
        }
        return ans;
    }
};