class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        int mx = max(arr[0], arr[1]);
        int count = 1;
        if (k >= n - 1) return *max_element(arr.begin(), arr.end());
        for (int i = 2; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
                count = 1;
            } else {
                count++;
            }
            if (count == k) return mx;
        }
        return mx;
    }
};