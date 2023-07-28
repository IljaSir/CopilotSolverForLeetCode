class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        int n = tasks.size();
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; ++i) {
            int t = tasks[i];
            if (t % 2 == 0) {
                ++cnt[t];
            } else {
                ++cnt[t - 1];
                ++cnt[t + 1];
            }
        }
        int res = 0;
        for (auto [k, v]: cnt) {
            int r = v % 4;
            int q = v / 4;
            if (r == 0) {
                res += q * 2;
            } else if (r == 1) {
                res += (q * 2) + 1;
            } else if (r == 2) {
                res += (q * 2) + 2;
            } else {
                res += (q * 2) + 3;
            }
        }
        return res;
    }
};