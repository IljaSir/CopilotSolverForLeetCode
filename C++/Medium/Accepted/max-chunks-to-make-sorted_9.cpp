class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        int chunk = 0;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (max == i) {
                ++chunk;
            }
        }
        return chunk;
    }
};