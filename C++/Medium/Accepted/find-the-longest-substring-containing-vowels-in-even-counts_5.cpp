class Solution {
public:
    int findTheLongestSubstring(string s) {
        
        int n = s.length();
        int ans = 0;
        int state = 0;
        vector<int> pos(1 << 5, -1);
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                state ^= 1 << 0;
            } else if (s[i] == 'e') {
                state ^= 1 << 1;
            } else if (s[i] == 'i') {
                state ^= 1 << 2;
            } else if (s[i] == 'o') {
                state ^= 1 << 3;
            } else if (s[i] == 'u') {
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