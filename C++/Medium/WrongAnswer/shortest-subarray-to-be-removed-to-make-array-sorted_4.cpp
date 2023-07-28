class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        
        int n = arr.size();
        int i = 1;
        while (i < n && arr[i] >= arr[i - 1]) {
            i++;
        }
        if (i == n) {
            return 0;
        }
        int j = n - 2;
        while (j >= 0 && arr[j] <= arr[j + 1]) {
            j--;
        }
        int res = min(n - i, j + 1);
        int k = 0;
        int l = j;
        while (k < i && l < n) {
            if (arr[l] >= arr[k]) {
                res = min(res, l - k - 1);
                k++;
            } else {
                l++;
            }
        }
        return res;
    }
};