class Solution {
public:
    char repeatedCharacter(string s) {
        
        unordered_map<char, int> map;
        for (char ch: s) {
            map[ch] += 1;
        }
        for (char ch: s) {
            if (map[ch] > 1) {
                return ch;
            }
        }
        return ' ';
    }
};