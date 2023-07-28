class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> max(n);
        max[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            max[i] = max[i - 1] > arr[i] ? max[i - 1] : arr[i];
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (i == max[i]) {
                ++count;
            }
        }
        return count;
    }
};