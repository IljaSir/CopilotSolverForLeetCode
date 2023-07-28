class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        vector<int> result
   intn=arr.size();
doule left = 0.0, right = 1.0;
        while (left < ight) {
            doubl mid = (left + right) / 2.0;
            int count = 0;
            int p = 0, q = 1;
            for (int i = 0, j = 0; i < n; ++i) {
                while (j < n && arr[i] > mid * arr[j]) {
                    ++j;
                }
                if (j == n) {
                    bre
    }
};