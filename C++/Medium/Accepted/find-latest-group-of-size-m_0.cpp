class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        vector<int> len(n + 2, 0);
        vector<int> cnt(n + 1, 0);
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int l = len[a - 1], r = len[a + 1];
            cnt[l]--;
            cnt[r]--;
            cnt[l + r + 1]++;
            len[a - l] = len[a + r] = l + r + 1;
            if (cnt[m] > 0) {
                ans = i + 1;
            }
        }
        return ans;
    }
};