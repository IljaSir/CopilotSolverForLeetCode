class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        if (s.size() != goal.size()) {
            return false;
        }
        int count = 0;
        int first = -1;
        int second = -1;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != goal[i]) {
                count++;
                if (count > 2) {
                    return false;
                }
                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }
        if (count == 0) {
            int charMap[26] = {0};
            for (int i = 0; i < s.size(); i++) {
                if (charMap[s[i] - 'a'] > 0) {
                    return true;
                }
                charMap[s[i] - 'a']++;
            }
            return false;
        } else if (count == 2) {
            return s[first] == goal[second] && s[second] == goal[first];
        }
        return false;
    }
};