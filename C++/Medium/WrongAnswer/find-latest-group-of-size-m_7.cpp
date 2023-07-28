class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        if (n == m) return n;
        vector<int> left(n + 2, 0), right(n + 2, 0);
        vector<int> cnt(n + 1, 0);
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            left[a] = right[a] = a;
            if (left[a - 1] > 0) {
                left[a] = left[a - 1];
                cnt[right[a] - left[a - 1] + 1]--;
            }
            if (right[a + 1] > 0) {
                right[a] = right[a + 1];
                cnt[right[a + 1] - left[a] + 1]--;
            }
            cnt[right[a] - left[a] + 1]++;
            if (cnt[m] > 0) ans = i + 1;
        }
        return ans;
    }
};