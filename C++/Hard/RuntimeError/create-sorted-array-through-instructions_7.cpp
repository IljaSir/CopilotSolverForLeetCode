class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        vector<int> bit(n + 1, 0);
        auto lowbit = [](int x) { return x & (-x); };
        auto add = [&bit, &lowbit](int x, int v) {
            while (x <= bit.size()) {
                bit[x] += v;
                x += lowbit(x);
            }
        };
        auto sum = [&bit, &lowbit](int x) {
            int res = 0;
            while (x > 0) {
                res += bit[x];
                x -= lowbit(x);
            }
            return res;
        };
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = sum(instructions[i] - 1);
            int r = i - sum(instructions[i]);
            res = (res + min(l, r)) % 1000000007;
            add(instructions[i], 1);
        }
        return res;
    }
};