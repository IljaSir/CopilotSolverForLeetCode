class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        if (n == m) return n;
        vector<int> cnt(n + 2, 0);
        vector<int> len(n + 2, 0);
        int res = -1;
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            cnt[a - 1] = cnt[a + 1] = 0;
            len[a] = len[a - cnt[a - 1] - 1] + len[a + cnt[a + 1] + 1] + 1;
            cnt[a - len[a - 1]] = cnt[a + len[a + 1]] = len[a];
            if (len[a - len[a - 1]] == m || len[a + len[a + 1]] == m) res = i + 1;
        }
        return res;
    }
};