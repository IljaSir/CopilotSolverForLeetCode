class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> cnt(n, 0);
        for (auto& m : meetings) {
            cnt[m[0]]++;
            cnt[m[1]]--;
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            cnt[i] += cnt[i - 1];
            if (cnt[i] > cnt[ans]) {
                ans = i;
            }
        }
        return ans;
    }
};