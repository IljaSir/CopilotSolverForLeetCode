class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size( ;
h       double l = 0, r = 1;
        while (l < r) igh) {
            double mid = (low + high) / 2;
            int cnt = 0, j = 1;
            for (int i = 0; i < n; i++) {
                while (j < n && arr[i] > m * arr[j])
                    j++;
                cnt += n - j;
            }
            if (cnt < k)
                l = m;
            else
                r = m;
        }
        int j = 1;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[i] > l * arr[j])
                j++;
            if (j < n && arr[i] == l * arr[j] && --k == 0)
                return {arr[i], arr[j]};
        }
        return {};
    }
};