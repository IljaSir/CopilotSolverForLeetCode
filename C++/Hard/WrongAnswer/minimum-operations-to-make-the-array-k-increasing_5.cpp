class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        int ans = 0;
        for (int i = k; i < n; ++i) {
            if (arr[i] <= arr[i-k]) {
                ans += arr[i-k] - arr[i] + 1;
                arr[i] = arr[i-k] + 1;
            }
        }
        return ans;
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        int ans = 0;
        vector<int> diff;
        for (int i = 0; i < n-1; ++i) {
            diff.push_back(arr[i+1] - arr[i]);
        }
        sort(diff.begin(), diff.end());
        for (int i = 0; i < n-k; ++i) {
            ans += diff[i];
        }
        return ans + kIncreasing(arr, k);
    }
};