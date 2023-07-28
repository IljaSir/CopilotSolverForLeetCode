class Solution {
public:
    int longestMountain(vector<int>& arr) {
        
        int n = arr.size();
        if(n < 3) return 0;
        int ans = 0;
        int left = 0;
        int right = 1;
        while(right < n) {
            if(arr[right] <= arr[left]) {
                left = right;
                right++;
                continue;
            }
            int j = right;
            while(j < n && arr[j] > arr[j - 1]) j++;
            if(j == n) {
                left = right;
                right++;
                continue;
            }
            int k = j;
            while(k < n && arr[k] < arr[k - 1]) k++;
            ans = max(ans, k - left);
            left = right;
            right++;
        }
        return ans;
    }
};