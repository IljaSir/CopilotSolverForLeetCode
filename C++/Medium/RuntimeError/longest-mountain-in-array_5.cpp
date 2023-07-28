class Solution {
public:
    int longestMountain(vector<int>& arr) {
        
        int n = arr.size();
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            int left = i - 1;
            int right = i + 1;
            if (arr[left] < arr[i] && arr[i] > arr[right]) {
                while (left >= 0 && arr[left] < arr[left + 1]) {
                    --left;
                }
                while (right < n && arr[right] < arr[right - 1]) {
                    ++right;
                }
                ans = max(ans, right - left - 1);
            }
        }
        return ans;
    }
};