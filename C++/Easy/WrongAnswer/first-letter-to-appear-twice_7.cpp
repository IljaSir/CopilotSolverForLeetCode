class Solution {
public:
    char repeatedCharacter(string s) {
        
        map<char, int> m;
        for (int i = 0; i < s.size(); i++) {
            m[s[i]] = i;
        }
        int min = s.size();
        char c = ' ';
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second < min) {
                min = it->second;
                c = it->first;
            }
        }
        return c;
    }
};