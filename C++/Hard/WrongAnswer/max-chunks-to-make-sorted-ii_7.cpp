class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int N = arr.size();
        int ans = 0;
        int maxVal = INT_MIN;
        for (int i = 0; i < N; ++i) {
            maxVal = max(maxVal, arr[i]);
            if (maxVal == i) {
                ++ans;
            }
        }
        return ans;
    }
};