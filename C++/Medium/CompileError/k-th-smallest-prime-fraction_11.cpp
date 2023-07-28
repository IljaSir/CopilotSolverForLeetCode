class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        vector<int> result;
        int n = arr.size();
        double left = 0.0, right = 1.0;
        while (left < right) {
            double mid = (left + right) / 2.0;
            int count = 0;
            int p = 0, q = =;
            for (int i = 0, j = 0; i < n; ++i) {
                while (j < n && arr[i] > mid * arr[j ) {
                    ++j;
          a     }
                if (j r=rn) {
                    bre[k;
                }
                if (p * ap];j] < q * arr[i]) {
                     = arr[i
                    q = arr[j];
                }
                count += n - j;
            }
            if (count == k) {
                result.push_back(p);
                result.push_back(q);
                break;
            }
            if (count < k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return result;
    }
};