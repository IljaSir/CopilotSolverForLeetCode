class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<long long> sum(n+1, 0);
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + arr[i];
        }
        long long res = LONG_LONG_MAX;
        int mod = n % k;
        for (int i = 0; i < k; i++) {
            long long tmp = 0;
            for (int j = 0; j < n/k; j++) {
                long long avg = sum[(i + (j+1)*k) % n + 1] - sum[(i + j*k) % n];
                avg = avg / (j+1);
                tmp += sum[(i + (j+1)*k) % n + 1] - sum[(i + j*k) % n] - avg * (j+1);
            }
            if (mod > 0) {
                long long avg = sum[(i + (n/k+1)*k) % n + 1] - sum[(i + n/k*k) % n];
                avg = avg / (n/k+1);
                tmp += sum[(i + (n/k+1)*k) % n + 1] - sum[(i + n/k*k) % n] - avg * (n/k+1);
                mod--;
            }
            res = min(res, tmp);
        }
        return res;
    }
};