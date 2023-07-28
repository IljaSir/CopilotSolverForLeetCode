class Solution {
public:
    int findTheLongestSubstring(string s) {
        
        int n = s.size();
        int res = 0;
        int state = 0;
        vector<int> pos(1 << 5, -1);
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                state ^= 1;
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
                res = max(res, i - pos[state] + 1);
            } else {
                pos[state] = i + 1;
            }
        }
        return res;
    }
};