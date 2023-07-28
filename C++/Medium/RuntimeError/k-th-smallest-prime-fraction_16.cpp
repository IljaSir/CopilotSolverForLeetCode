class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> ans(2);
        double lo = 0, hi = 1;
        while (lo < hi) {
            double mid = (lo + hi) / 2;
            int count = 0, j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                count += n - j;
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1e-9;
            }
        }
        int p = 0, q = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (arr[i] > lo * arr[p]) {
                p++;
            }
            if (q * arr[i] > p * arr[q]) {
                q = i;
            }
            count += n - p;
        }
        ans[0] = arr[q];
        ans[1] = arr[p];
        return ans;
    }
};