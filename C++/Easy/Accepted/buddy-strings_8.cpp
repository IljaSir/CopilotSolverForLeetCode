class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        if (s.size() != goal.size()) {
            return false;
        }
        
        int diff = 0;
        int first = -1;
        int second = -1;
        int count[26] = {0};
        for (int i = 0; i < s.size(); i++) {
            count[s[i] - 'a']++;
            if (s[i] != goal[i]) {
                diff++;
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        
        if (diff == 0) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 1) {
                    return true;
                }
            }
        } else if (diff == 2) {
            return s[first] == goal[second] && s[second] == goal[first];
        }
        
        return false;
    }
};