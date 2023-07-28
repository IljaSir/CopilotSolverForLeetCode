class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        int ans = 0;
        vector<int> cnt(n, 0);
        for (auto& m : meetings) {
            int start = m[0];
            int end = m[1];
            for (int i = start; i < end; ++i) {
                ++cnt[i];
            }
        }
        for (int i = 0; i < n; ++i) {
            if (cnt[i] > cnt[ans]) ans = i;
        }
        return ans;
    }
};