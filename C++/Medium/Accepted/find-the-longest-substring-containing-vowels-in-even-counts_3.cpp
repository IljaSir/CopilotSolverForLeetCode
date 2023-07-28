class Solution {
public:
    int findTheLongestSubstring(string s) {
        
        int n = s.size();
        int ans = 0;
        int state = 0;
        vector<int> pos(1 << 5, -1);
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s[i];
            if (ch == 'a') {
                state ^= 1 << 0;
            } else if (ch == 'e') {
                state ^= 1 << 1;
            } else if (ch == 'i') {
                state ^= 1 << 2;
            } else if (ch == 'o') {
                state ^= 1 << 3;
            } else if (ch == 'u') {
                state ^= 1 << 4;
            }
            if (~pos[state]) {
                ans = max(ans, i + 1 - pos[state]);
            } else {
                pos[state] = i + 1;
            }
        }
        return ans;
    }
};