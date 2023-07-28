class Solution {
public:
    int longestMountain(vector<int>& arr) {
        
        int n = arr.size();
        if (n < 3) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n) {
            while (i < n - 1 && arr[i] >= arr[i + 1]) {
                i++;
            }
            j = i + 1;
            while (j < n - 1 && arr[j] < arr[j + 1]) {
                j++;
            }
            if (j == n - 1) {
                break;
            }
            int k = j + 1;
            while (k < n && arr[k] < arr[k - 1]) {
                k++;
            }
            ans = max(ans, k - i);
            i = j;
        }
        return ans;
    }
};