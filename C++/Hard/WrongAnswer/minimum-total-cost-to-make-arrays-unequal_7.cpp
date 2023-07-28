class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            a[i] = nums1[i] - nums2[i];
        }
        sort(a.begin(), a.end());
        long long ans = 0;
        int i = 0;
        while (i < n && a[i] < 0) {
            ans += -a[i];
            i++;
        }
        if (i == n) {
            return ans;
        }
        int j = i;
        while (j < n && a[j] == 0) {
            j++;
        }
        if (j == n) {
            return -1;
        }
        ans += j - i;
        int k = j;
        while (k < n) {
            ans += k - i;
            k++;
        }
        return ans;
    }
};