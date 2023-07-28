class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        long long sum = accumulate(begin(arr), end(arr), 0LL);
        long long target = sum / k;
        if (target * k != sum) return -1;
        long long res = 0;
        long long cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += arr[i];
            if (i >= k) cur -= arr[i - k];
            if (i >= k - 1) res = max(res, cur);
        }
        return target * k - res;
    }
};