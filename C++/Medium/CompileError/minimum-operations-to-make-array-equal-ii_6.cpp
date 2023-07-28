class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        int m = nums2.size();
        if (n * 6 < k || m * 6 < k) return -1;
        vector<int> s1(6 * n + 1, 0);
        vector<int> s2(6 * m + 1, 0);
        for (int i = 0; i < n; i++) {
            s1[nums1[i]]++;
        }
        for (int i = 0; i < m; i++) {
            s2[nums2[i]]++;
        }
        for (int i = 1; i <= 6 * n; i++) {
            s1[i] += s1[i - 1];
        }
        for (int i = 1; i <= 6 * m; i++) {
            s2[i] += s2[i - 1];
        }
        long long ans = 1e18;
        for (int i = 0; i <= k; i++) {
            if (i * 6 > k) break;
            int j = k - i;
            if (j * 6 < k) continue;
            int l = max(0, i - m);
            int r = min(n, i);
            for (int x = l; x <= r; x++) {
                int y = k - x;
                int lo = 1, hi = 6 * m;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (s2[mid] < y) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                int a = hi;
                lo = 1, hi = 6 * m;
                while (lo < hi) {
                    int mid = (lo + hi + 1) / 2;
                    if (s2[mid] > 6 * m - y) {
                        hi = mid - 1;
                    } else {
                        lo = mid;
                    }
                }
                int b = lo;
                lo = 1, hi = 6 * n;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (s1[mid] < x) {
                        lo = mid +
    }
};