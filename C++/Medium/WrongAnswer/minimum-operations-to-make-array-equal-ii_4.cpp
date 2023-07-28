class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        vector<int> diff(n, 0);
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        sort(diff.begin(), diff.end());
        vector<long long> prefix(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + diff[i - 1];
        }
        int l = 0, r = n;
        long long res = LLONG_MAX;
        while (l <= min(k, n) && r >= max(n - k, 0)) {
            res = min(res, (long long)k * (long long)l - prefix[l] + prefix[r] - (long long)k * (long long)(n - r));
            if (l == k || r == n - k) break;
            if (prefix[l] - l * (long long)k < (long long)(n - r) * k - prefix[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res > 0 ? -1 : res;
    }
};