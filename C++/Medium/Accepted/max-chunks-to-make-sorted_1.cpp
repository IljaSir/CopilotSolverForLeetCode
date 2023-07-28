class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (max == i) {
                count++;
            }
        }
        return count;
    }
};