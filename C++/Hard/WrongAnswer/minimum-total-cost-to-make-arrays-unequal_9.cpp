class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int m = nums2.size();
        if (n != m) return -1;
        vector<int> a(100001, 0);
        vector<int> b(100001, 0);
        vector<int> c(100001, 0);
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                c[nums1[i]]++;
            }
            else {
                a[nums1[i]]++;
                b[nums2[i]]++;
            }
        }
        int mx = 0;
        for (int i = 0; i <= 100000; i++) {
            if (a[i] > 0 || b[i] > 0) {
                mx = max(mx, i);
            }
        }
        long long ans = 0;
        for (int i = 1; i <= mx; i++) {
            if (a[i] == 0 && b[i] == 0) {
                ans += (long long)c[i] * i;
            }
            else {
                ans += (long long)(c[i] + 1) * i;
            }
        }
        return ans;
    }
};