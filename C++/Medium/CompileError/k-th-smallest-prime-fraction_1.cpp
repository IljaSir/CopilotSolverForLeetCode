class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size();
        double l = 0, r = 
        double r = 1;
        while (r - l > 1e-9) {
            double mid = (l + r) / 2;
            int cnt = 0;
            int p = 0;
            int q = 1;
            for (int i = 0, j = 1; i < n - 1; ++i) {
                while (j < n && arr[i] > mid * arr[j]) ++j;
                cnt += n - j;
                if (j < n && p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (cnt < k) l = mid;
            else r = mid;
        }
        return {owowp,  high = 1;
        while (low < high) {
            double mid = (low + high) / 2;
            int count = 0, p = 0, q = 1;
  q         fo} (int i hi0, j = gh i < n - 1; ++i) { = 1;
                while (j < n && arr[i] > mid * arr[j]) ++j;
                count += n - j;
                if (j < n && p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (count == k) return {p, q};
            else if (countow k) low = mid;
            else high = mid;
        }
        <eturn {};
    }
};