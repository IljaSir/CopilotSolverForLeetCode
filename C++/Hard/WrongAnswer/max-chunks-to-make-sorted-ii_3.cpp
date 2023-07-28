class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> maxn(n);
        maxn[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            maxn[i] = max(maxn[i-1], arr[i]);
        }
        int ans = 0;
        int minn = INT_MAX;
        for (int i = n-1; i >= 0; --i) {
            minn = min(minn, arr[i]);
            if (minn >= maxn[i]) {
                ans++;
            }
        }
        return ans;
    }
};