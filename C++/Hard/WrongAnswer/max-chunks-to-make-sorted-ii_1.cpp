class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int ans = 0;
        int maxVal = 0;
        for (int i = 0; i < arr.size(); i++) {
            maxVal = max(maxVal, arr[i]);
            if (maxVal == i) {
                ans++;
            }
        }
        return ans;
    }
};