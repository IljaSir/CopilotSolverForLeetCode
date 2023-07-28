class Solution {
public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        
        int n = nums1.size();
        int m = nums2.size();
        if (n > m) return kthSmallestProduct(nums2, nums1, k);
        long long ans = 0;
        long long low = nums1[0] * nums2[0];
        long long high = nums1[n - 1] * nums2[m - 1];
        while (low <= high) {
            long long mid = low + (high - low) / 2;
            if (check(nums1, nums2, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    bool check(vector<int>& nums1, vector<int>& nums2, long long mid, long long k) {
        int n = nums1.size();
        int m = nums2.size();
        long long cnt = 0;
        for (int i = 0; i < n; ++i) {
            int l = 0;
            int r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums1[i] * nums2[mid] <= mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            cnt += l;
        }
        return cnt < k;
    }
};