class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        vector<int> len(n+2, 0);
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            int left = len[a-1], right = len[a+1];
            len[a] = len[a-left] = len[a+right] = left + right + 1;
            if (left == m || right == m) ans = i;
        }
        return ans;
    }
};