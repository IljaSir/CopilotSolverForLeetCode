class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        vector<int> sum(n + 1);
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + arr[i];
        int l = 0, r = arr.back();
        while (l < r) {
            int m = (l + r) >> 1;
            int i = upper_bound(arr.begin(), arr.end(), m) - arr.begin();
            int s = sum[i] + (n - i) * m;
            if (s >= target) r = m;
            else l = m + 1;
        }
        int i = upper_bound(arr.begin(), arr.end(), l) - arr.begin();
        int s1 = sum[i] + (n - i) * l;
        int s2 = sum[i] + (n - i) * (l - 1);
        return abs(s1 - target) <= abs(s2 - target) ? l : l - 1;
    }
};