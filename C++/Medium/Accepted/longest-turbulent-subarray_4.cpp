class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        int res = 1;
        int l = 0, r = 0;
        while (r < n - 1) {
            if (l == r) {
                if (arr[l] == arr[l + 1]) {
                    l++;
                }
                r++;
            } else {
                if (arr[r - 1] < arr[r] && arr[r] > arr[r + 1]) {
                    r++;
                } else if (arr[r - 1] > arr[r] && arr[r] < arr[r + 1]) {
                    r++;
                } else {
                    l = r;
                }
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
};