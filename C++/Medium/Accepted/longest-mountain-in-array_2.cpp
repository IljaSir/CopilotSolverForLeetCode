class Solution {
public:
    int longestMountain(vector<int>& arr) {
        
        int n = arr.size();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            if (j + 1 < n && arr[j] < arr[j + 1]) {
                while (j + 1 < n && arr[j] < arr[j + 1]) j++;
                if (j + 1 < n && arr[j] > arr[j + 1]) {
                    while (j + 1 < n && arr[j] > arr[j + 1]) j++;
                    ans = max(ans, j - i + 1);
                }
            }
            i = max(i + 1, j);
        }
        return ans;
    }
};