class Solution {
public:
    int longestMountain(vector<int>& arr) {
        
        int n = arr.size();
        if (n < 3) return 0;
        int res = 0;
        int i = 1;
        while (i < n) {
            int j = i;
            if (arr[i-1] < arr[i]) {
                while (j+1 < n && arr[j] < arr[j+1]) j++;
                if (j+1 < n && arr[j] > arr[j+1]) {
                    while (j+1 < n && arr[j] > arr[j+1]) j++;
                    res = max(res, j-i+1);
                }
            }
            i = max(j, i+1);
        }
        return res;
    }
};