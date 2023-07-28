class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        int mod = 1e9 + 7;
        vector<int> bit(1e5 + 1);
        auto lowbit = [](int x) { return x & -x; };
        auto add = [&](int x, int v) {
            for (; x < bit.size(); x += lowbit(x)) {
                bit[x] += v;
            }
        };
        auto query = [&](int x) {
            int res = 0;
            for (; x > 0; x -= lowbit(x)) {
                res += bit[x];
            }
            return res;
        };
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            int x = instructions[i];
            int left = query(x - 1);
            int right = i - query(x);
            res += min(left, right);
            add(x, 1);
        }
        return res % mod;
    }
};