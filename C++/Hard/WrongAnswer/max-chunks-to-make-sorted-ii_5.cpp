class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        int cnt = 0;
        int maxn = 0;
        for (int i = 0; i < n; ++i) {
            maxn = max(maxn, arr[i]);
            if (maxn == i) ++cnt;
        }
        return cnt;
    }
};