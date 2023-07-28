class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        unordered_map<int, int> cnt;
        for (auto t : tasks) {
            int k = (t + 1) / 2;
            cnt[k]++;
        }
        int res = 0;
        for (auto [k, v] : cnt) {
            int r = v % 2;
            int q = v / 2;
            res += q;
            if (r) res++;
        }
        return res;
    }
};