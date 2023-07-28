class Solution {
public:
    int longestAwesome(string s) {
        
        int n = s.size();
        int ans = 0;
        vector<int> pos(1024, n);
        pos[0] = -1;
        int mask = 0;
        for (int i = 0; i < n; ++i) {
            mask ^= (1 << (s[i] - '0'));
            ans = max(ans, i - pos[mask]);
            for (int j = 0; j < 10; ++j) {
                ans = max(ans, i - pos[mask ^ (1 << j)]);
            }
            pos[mask] = min(pos[mask], i);
        }
        return ans;
    }
};