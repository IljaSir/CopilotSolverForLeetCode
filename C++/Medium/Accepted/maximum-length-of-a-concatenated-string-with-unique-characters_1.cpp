class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        int n = arr.size();
        vector<int> mask(n);
        for (int i = 0; i < n; i++) {
            for (char c : arr[i]) {
                int bit = c - 'a';
                if (mask[i] & (1 << bit)) {
                    mask[i] = 0;
                    break;
                }
                mask[i] |= 1 << bit;
            }
        }
        int ans = 0;
        function<void(int, int)> backtrack = [&](int pos, int cur) {
            if (pos == n) {
                ans = max(ans, __builtin_popcount(cur));
                return;
            }
            if ((cur & mask[pos]) == 0) {
                backtrack(pos + 1, cur | mask[pos]);
            }
            backtrack(pos + 1, cur);
        };
        backtrack(0, 0);
        return ans;
    }
};