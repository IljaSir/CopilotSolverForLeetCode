class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        const int M = 1e9 + 7;
        int n = instructions.size();
        vector<int> c(1e5 + 1);
        auto lowbit = [](int x) { return x & -x; };
        auto update = [&](int x, int v) {
            for (int i = x; i < c.size(); i += lowbit(i)) c[i] += v;
        };
        auto query = [&](int x) {
            int ret = 0;
            for (int i = x; i > 0; i -= lowbit(i)) ret += c[i];
            return ret;
        };
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int v = instructions[i];
            int left = query(v - 1);
            int right = i - query(v);
            ans = (ans + min(left, right)) % M;
            update(v, 1);
        }
        return ans;
    }
};