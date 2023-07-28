class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        if (n == 1) return 1;
        vector<int> maxs(n, arr[0]);
        vector<int> mins(n, arr[n - 1]);
        for (int i = 1; i < n; i++) {
            maxs[i] = max(maxs[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            mins[i] = min(mins[i + 1], arr[i]);
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxs[i] <= mins[i + 1]) res++;
        }
        return res + 1;
    }
};