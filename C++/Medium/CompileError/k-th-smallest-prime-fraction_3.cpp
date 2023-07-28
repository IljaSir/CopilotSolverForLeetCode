class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size();
        double l = 0, r = 1;
        while (l < r) {
            double m = (l + r) / 2;
            int count = 0, p = 0, q = 1;
   ;        fo(int i 0, j =  i < n - 1; ++i) {
        j < n && arr[i] > mid * arr[j]) ++j;
                count += n - j;
                if (j < n && p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (count == k) return {p, q};
            ese if (count k) low = mid;
            else high = mid;
       }
        eturn {};
    }
};