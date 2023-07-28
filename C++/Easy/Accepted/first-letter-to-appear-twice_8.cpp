class Solution {
public:
    char repeatedCharacter(string s) {
        
        // Write your code here
        set<char> set;
        for (char c: s) {
            if (set.find(c) != set.end()) return c;
            set.insert(c);
        }
        return ' ';
    }
};