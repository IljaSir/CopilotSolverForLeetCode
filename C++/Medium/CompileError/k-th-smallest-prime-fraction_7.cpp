class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        i n = arr.size();
        vector<int> ans(2);
        double lo = 0, hi = 1;
        while (lo < hi) {
            double mid = (lo + hi) / 2;
            int count = 0, j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                co;
    }
};