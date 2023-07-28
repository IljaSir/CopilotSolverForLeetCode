class Solution {
public:
    string greatestLetter(string s) {
        
        vector<int> count(26, 0);
        for (char c: s) {
            count[tolower(c) - 'a']++;
        }
        for (int i = 25; i >= 0; i--) {
            if (count[i] > 0 && count[i] < s.size()) {
                return string(1, 'A' + i);
            }
        }
        return "";
    }
};