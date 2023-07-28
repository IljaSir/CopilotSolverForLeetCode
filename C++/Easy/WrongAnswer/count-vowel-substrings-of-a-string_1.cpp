class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int count = 0;
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        for (auto c : word) {
            if (c == 'a') {
                a = 1 + a + e + i + o + u;
            } else if (c == 'e') {
                e = e + i + o + u;
            } else if (c == 'i') {
                i = i + o + u;
            } else if (c == 'o') {
                o = o + u;
            } else if (c == 'u') {
                u = u + 1;
            }
            count += a;
        }
        return count;
    }
};