class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size();
        double l = 0;
        dble r = 1;
        vector<i> ans;
        while (l < r) {
           double mid = l + (r  l) / 2;
            intp = 0;
            int q = ;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                int j = upper_bound(arr.begin(), arr.end(), mid * arr[i) - arr.begin()
                if (j < n) {
                    if (p * arr[j] < q*arr[i]){
           p = arr[i];
                        q = arr[j];
                    }
                    cnt += n - j;
                }
            }
            if (cnt == k) {
                ans = {p, q};
                k;
            } else if (cnt < ) {
                l = mid
        int n else { = arr.size(;
       d        r = mid;
            ouble l = 0, r = 1;
        }
        while (l < r) 
    }
};