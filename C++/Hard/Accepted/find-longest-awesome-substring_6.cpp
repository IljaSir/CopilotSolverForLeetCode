class Solution {
public:
    int longestAwesome(string s) {
        
        int n = s.size();
        int ans = 0;
        vector<int> pos(1024, n);
        pos[0] = -1;
        int state = 0;
        for (int i = 0; i < n; i++) {
            state ^= 1 << (s[i] - '0');
            for (int j = 0; j < 10; j++) {
                ans = max(ans, i - pos[state ^ (1 << j)]);
            }
            ans = max(ans, i - pos[state]);
            pos[state] = min(pos[state], i);
        }
        return ans;
    }
};