class Solution {
public:
    int countValidWords(string sentence) {
        
        int count = 0;
        int state = 0;
        for (char c : sentence) {
            if (c == ' ') {
                if (state == 1) ++count;
                state = 0;
            } else if (c == '-') {
                if (state == 1) state = 3;
                else if (state == 0) state = 2;
                else return 0;
            } else if (c == '!' || c == '.' || c == ',') {
                if (state == 1) state = 4;
                else return 0;
            } else {
                if (state == 0) state = 1;
                else if (state == 3 || state == 4) return 0;
            }
        }
        if (state == 1) ++count;
        return count;
    }
};