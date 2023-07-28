class Solution {
public:
    int longestMountain(vector<int>& arr) {
        
        int n = arr.size();
        if (n < 3) {
            return 0;
        }
        int res = 0;
        int l = 0;
        int r = 1;
        while (r < n) {
            if (arr[r] > arr[r - 1]) {
                r++;
                continue;
            }
            if (arr[r] == arr[r - 1]) {
                l = r;
                r++;
                continue;
            }
            if (r - l < 2) {
                l = r;
                r++;
                continue;
            }
            int t = r;
            while (t < n && arr[t] < arr[t - 1]) {
                t++;
            }
            res = max(res, t - l);
            l = t - 1;
            r = t;
        }
        return res;
    }
};