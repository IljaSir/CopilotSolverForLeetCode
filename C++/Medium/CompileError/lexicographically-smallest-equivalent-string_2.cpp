class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        
        int p[26];
        for (int i = 0; i < 26; ++i) p[i] = i;
        for (int i = 0; i < s1.size(); ++i) {
            int x = s1[i] - 'a', y = s2[i] - 'a';
            int px = find(p, x), py = find(p, y);
            if (px < py) p[py] = px;
            else p[px] = py;
        }
        for (int i = 0; i < baseStr.size(); ++i) {
            baseStr[i] = 'a' + find(p, baseStr[i] - 'a');
        }
        return baseStr;
    }
};