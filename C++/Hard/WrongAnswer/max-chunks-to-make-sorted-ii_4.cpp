class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> maxs(n, arr[0]);
        for (int i = 1; i < n; i++) {
            maxs[i] = max(maxs[i - 1], arr[i]);
        }
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (maxs[i] <= arr[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
};