class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> maxs(n, arr[0]);
        for (int i = 1; i < n; i++) {
            maxs[i] = max(maxs[i - 1], arr[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (maxs[i] == i) {
                res++;
            }
        }
        return res;
    }
};