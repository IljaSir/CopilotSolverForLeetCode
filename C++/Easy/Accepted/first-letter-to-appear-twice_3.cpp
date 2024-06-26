class Solution {
public:
    char repeatedCharacter(string s) {
        
        unordered_map<char, int> m;
        for (char c : s) {
            m[c]++;
            if (m[c] == 2) return c;
        }
        return ' ';
    }
};