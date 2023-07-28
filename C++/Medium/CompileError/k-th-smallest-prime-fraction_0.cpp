class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size();
        double l = 0;
        double r = 1;
        while (r - l > 1e-9) {
            double mid = (l + r) / 2;
            int cnt = 0;
            int p = 0;
            int q = 1;
            for (int i = 0; j = 1; i < n - 1; ++i) {
               while (j < n && arr[i] > mid * ar[j]) ++j;
               cnt + n - j;
                if (j < n && p * arr[j] < q * arr[i]) {
                   p = arr[i];
                    q = arr[j];
                }
            }
            if (cnt < k) l = mid;
            else r = mid;
        }
        return {p, q};
    }
};