class Solution {
public:
    int findTheLongestSubstring(string s) {
        
        vector<int> pos(1 << 5, -1);
        pos[0] = 0;
        int res = 0, status = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] == 'a') status ^= 1;
            else if (s[i] == 'e') status ^= 2;
            else if (s[i] == 'i') status ^= 4;
            else if (s[i] == 'o') status ^= 8;
            else if (s[i] == 'u') status ^= 16;
            if (~pos[status]) res = max(res, i + 1 - pos[status]);
            else pos[status] = i + 1;
        }
        return res;
    }
};