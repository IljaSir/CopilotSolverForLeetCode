class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        if (n == m) return n;
        vector<int> left(n + 2, 0);
        vector<int> right(n + 2, 0);
        vector<int> cnt(n + 2, 0);
        int res = -1;
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            left[a] = a - 1;
            right[a] = a + 1;
            cnt[left[a]] += cnt[a] + 1;
            cnt[right[a]] += cnt[a] + 1;
            left[right[a]] = left[a];
            right[left[a]] = right[a];
            if (cnt[left[a]] == m || cnt[right[a]] == m) res = i + 1;
        }
        return res;
    }
};