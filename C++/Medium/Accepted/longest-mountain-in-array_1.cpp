class Solution {
public:
    int longestMountain(vector<int>& arr) {
        
        int ans = 0;
        int n = arr.size();
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int l = i - 1;
                int r = i + 1;
                while (l > 0 && arr[l - 1] < arr[l]) {
                    l--;
                }
                while (r < n - 1 && arr[r + 1] < arr[r]) {
                    r++;
                }
                ans = max(ans, r - l + 1);
            }
        }
        return ans;
    }
};