class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        int mod = 1e9 + 7;
        vector<int> c(100001);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = instructions[i];
            int y = min(c[x - 1], i - c[x]);
            ans = (ans + y) % mod;
            for (int j = x; j <= 100000; j += j & -j) {
                c[j]++;
            }
        }
        return ans;
    }
};