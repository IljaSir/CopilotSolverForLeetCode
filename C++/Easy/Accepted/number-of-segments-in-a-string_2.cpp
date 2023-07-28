class Solution {
public:
    int countSegments(string s) {
        
        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ' ') {
                continue;
            }
            count++;
            while (i < s.size() && s[i] != ' ') {
                i++;
            }
        }
        return count;
    }
};