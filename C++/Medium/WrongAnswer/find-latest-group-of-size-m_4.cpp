class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        int ans = -1;
        vector<int> len(n + 2, 0);
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            int left = len[a - 1], right = len[a + 1];
            int sum = left + right + 1;
            len[a - left] = len[a + right] = sum;
            if (left == m || right == m) {
                ans = i;
            }
        }
        return ans;
    }
};